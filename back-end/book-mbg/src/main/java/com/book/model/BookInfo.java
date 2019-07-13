package com.book.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BookInfo implements Serializable {
    private Long id;

    private Integer bookCategoryId;

    private Integer storeId;

    private String name;

    private String outline;

    private String detail;

    private String press;

    private String author;

    private String publishDate;

    private String size;

    private String version;

    private String translator;

    private String isbn;

    private BigDecimal price;

    private Integer pages;

    private String catalog;

    private BigDecimal marketPrice;

    private BigDecimal memberPrice;

    private Integer dealMount;

    private Integer lookMount;

    private BigDecimal discount;

    private String imageUrl;

    private Integer storeMount;

    private Date storeTime;

    private String packStyle;

    private String isShelf;

    private String cname;

    private String description;

    private String cata;

    private String content;

    private Date created;

    private Date updated;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBookCategoryId() {
        return bookCategoryId;
    }

    public void setBookCategoryId(Integer bookCategoryId) {
        this.bookCategoryId = bookCategoryId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getMemberPrice() {
        return memberPrice;
    }

    public void setMemberPrice(BigDecimal memberPrice) {
        this.memberPrice = memberPrice;
    }

    public Integer getDealMount() {
        return dealMount;
    }

    public void setDealMount(Integer dealMount) {
        this.dealMount = dealMount;
    }

    public Integer getLookMount() {
        return lookMount;
    }

    public void setLookMount(Integer lookMount) {
        this.lookMount = lookMount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getStoreMount() {
        return storeMount;
    }

    public void setStoreMount(Integer storeMount) {
        this.storeMount = storeMount;
    }

    public Date getStoreTime() {
        return storeTime;
    }

    public void setStoreTime(Date storeTime) {
        this.storeTime = storeTime;
    }

    public String getPackStyle() {
        return packStyle;
    }

    public void setPackStyle(String packStyle) {
        this.packStyle = packStyle;
    }

    public String getIsShelf() {
        return isShelf;
    }

    public void setIsShelf(String isShelf) {
        this.isShelf = isShelf;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCata() {
        return cata;
    }

    public void setCata(String cata) {
        this.cata = cata;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", bookCategoryId=").append(bookCategoryId);
        sb.append(", storeId=").append(storeId);
        sb.append(", name=").append(name);
        sb.append(", outline=").append(outline);
        sb.append(", detail=").append(detail);
        sb.append(", press=").append(press);
        sb.append(", author=").append(author);
        sb.append(", publishDate=").append(publishDate);
        sb.append(", size=").append(size);
        sb.append(", version=").append(version);
        sb.append(", translator=").append(translator);
        sb.append(", isbn=").append(isbn);
        sb.append(", price=").append(price);
        sb.append(", pages=").append(pages);
        sb.append(", catalog=").append(catalog);
        sb.append(", marketPrice=").append(marketPrice);
        sb.append(", memberPrice=").append(memberPrice);
        sb.append(", dealMount=").append(dealMount);
        sb.append(", lookMount=").append(lookMount);
        sb.append(", discount=").append(discount);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", storeMount=").append(storeMount);
        sb.append(", storeTime=").append(storeTime);
        sb.append(", packStyle=").append(packStyle);
        sb.append(", isShelf=").append(isShelf);
        sb.append(", cname=").append(cname);
        sb.append(", description=").append(description);
        sb.append(", cata=").append(cata);
        sb.append(", content=").append(content);
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}