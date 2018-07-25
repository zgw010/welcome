package org.group.welcome.vo;

public class Page {
    int pageNow;
    int infoNumber;//共有信息数
    int pageCount=2;//每页显示的信息数
    int pageSum;

    //总页数
    public int getPageSum() {
        pageSum=(infoNumber%pageCount==0?infoNumber/pageCount:infoNumber/pageCount+1);
        return pageSum;
    }

    public void setPageSum(int pageSum) {
        this.pageSum = pageSum;
    }

    //当前页

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    //记录数，每页记录数

    public int getInfoNumber() {
        return infoNumber;
    }

    public void setInfoNumber(int infoNumber) {
        this.infoNumber = infoNumber;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
