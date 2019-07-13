// 字段排序函数
const compare = property => {
  return function (a, b) {
    var value1 = a[property];
    var value2 = b[property];
    return value1 - value2;
  };
};

// reverse order
const reverseCompare = property => {
  return (a, b) => {
    let val1 = a[property]
    let val2 = b[property]
    return val2 - val1
  }
}

// 获取排序后的列表
export const orderListBy = (list, order) => {
  const l = list.sort(compare(order))
  return l;
};

// get reverse order list
export const reverseOrderListBy = (list, order) => {
  const l = list.sort(reverseCompare(order))
  return l
};
