package com.book.component;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.ItemUserAverageRecommender;
import org.apache.mahout.cf.taste.impl.recommender.svd.ALSWRFactorizer;
import org.apache.mahout.cf.taste.impl.recommender.svd.SVDRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 夏日云泊镇 on 2019/7/8
 **/
@Component
public class BookRecommender {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookRecommender.class);

    final private int NEIGHBORHOOD_NUM = 20;

    private DataModel dataModel;

    public BookRecommender() {
        initDataModel();
    }

    private void initDataModel() {
        try {
            dataModel = new FileDataModel(new File("./book-main/src/main/resources/ratings/bx_book_ratings.txt"));
        } catch (Exception e) {

        }
    }

    private List<Long> getRecommendedItemIDs(List<RecommendedItem> recommendations){
        List<Long> recommendItems = new ArrayList<Long>();
        for(int i = 0 ; i < recommendations.size() ; i++) {
            RecommendedItem recommendedItem=recommendations.get(i);
            recommendItems.add(recommendedItem.getItemID());
        }
        return recommendItems;
    }

    public List<Long> userBasedRecommender(long userID,int size) throws TasteException {
        List<RecommendedItem> recommendations = new ArrayList<RecommendedItem>();
        try {
            UserSimilarity similarity  = new EuclideanDistanceSimilarity(dataModel);
            NearestNUserNeighborhood neighbor = new NearestNUserNeighborhood(NEIGHBORHOOD_NUM, similarity, dataModel );
            Recommender recommender = new GenericUserBasedRecommender(dataModel, neighbor, similarity);
            recommendations = recommender.recommend(userID, size);
            return getRecommendedItemIDs(recommendations);
    } catch (Exception e) {
        System.out.println(e.toString());
    }
        return getRecommendedItemIDs(recommendations);
    }

    public List<Long> itemBasedRecommender(long userID,int size) {
        List<RecommendedItem> recommendations = new ArrayList<RecommendedItem>();
        try {
            ItemSimilarity itemSimilarity = new PearsonCorrelationSimilarity(dataModel);
            Recommender recommender = new GenericItemBasedRecommender(dataModel, itemSimilarity);
            recommendations = recommender.recommend(userID, size);
            return getRecommendedItemIDs(recommendations);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return getRecommendedItemIDs(recommendations);
    }

    public List<Long> itemSVD(long userID, int size) {
        List<RecommendedItem> recommendations = new ArrayList<RecommendedItem>();
        try {
            Recommender recommender = new SVDRecommender(dataModel,
                    new ALSWRFactorizer(dataModel, 10, 0.6, 20));
            recommendations = recommender.recommend(userID, size);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return getRecommendedItemIDs(recommendations);
    }

    public List<Long> itemUserAverageCF(long userID,int size){
        List<Long> itemIDS = new ArrayList<>();
        try {
            Recommender recommender = new ItemUserAverageRecommender(dataModel);
            List<RecommendedItem> recommendations = recommender.recommend(userID, size);
            itemIDS = getRecommendedItemIDs(recommendations);
        } catch (Exception e) {
            LOGGER.info("获取推荐结果出错：" + e.toString());
        }
        return itemIDS;
    }
}
