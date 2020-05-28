package com.xuan.business.util;


public class Page {

    //开始页数
    private Integer pageNum = 1;
    //每页显示个数 默认每页显示5条
    private Integer pageSize = 5;
    //总个数
    private Integer count;
    //总页数
    private Integer totalPage;
    //参数
    private String param;


    public Page(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }


    private void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalPage() {
        initTotalPage();
        return totalPage;
    }

    private void initTotalPage() {
        int countPage;
        // 假设总数是50，是能够被5整除的，那么就有10页
        if (count % pageSize == 0) {
            countPage = count / pageSize;
            // 假设总数是51，不能够被5整除的，那么就有11页
        } else {
            countPage = count / pageSize + 1;
        }
        if (countPage == 0) {
            countPage = 1;
        }
        setTotalPage(countPage);

    }


    public void pageCheck(Integer count) {
        setCount(count);
        initTotalPage();
    }


    //这里应该是1 而不是0     https://pagehelper.github.io/docs/howtouse/
    public boolean isHasPrevious() {
        return (pageNum != 1);
    }

    public boolean isHasNext() {

        return (!pageNum.equals(getTotalPage()));
    }

    public Boolean getHasEndButton() {
        return (!pageNum.equals(getTotalPage())) && (pageNum != getTotalPage() - 1);
    }


    public Boolean getHasStartButton() {
        return (pageNum != 1) && (pageNum != 2);
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCount() {
        return count;
    }

    private void setCount(int count) {
        this.count = count;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }


}
