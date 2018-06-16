package com.keji.contest.gson;

import java.util.List;

/**
 * Created by lizehua035 on 2018/6/15.
 */
public class PaginationGson<T> {
    private long totalCount;
    private long totalPage;
    private long currentPage;
    private long pageSize=200;
    private long nextPage;
    private List<T> data;

   public PaginationGson(long totalCount,long currentPage){
        this.totalCount=totalCount;
        if(totalCount>0) {
            this.totalPage = totalCount / pageSize + 1;
            if(totalCount%pageSize==0){
                this.totalPage--;
            }
        }
        this.currentPage=currentPage;
    }
    public PaginationGson(long totalCount,long currentPage,long pageSize){
        this.pageSize=pageSize>0?pageSize:20;
        this.totalCount=totalCount;
        if(totalCount>0) {
            this.totalPage = totalCount / pageSize + 1;
            if(totalCount%pageSize==0){
                this.totalPage--;
            }
        }
        this.currentPage=currentPage;
    }
    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    public long getNextPage() {
        return nextPage;
    }

    public void setNextPage(long nextPage) {
        this.nextPage = nextPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getOffset(){
        return (currentPage-1)*pageSize;
    }

    public long getLimit(){
        return (currentPage-1)*pageSize+1;
    }
}
