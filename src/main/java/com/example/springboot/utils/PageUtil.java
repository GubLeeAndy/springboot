package com.example.springboot.utils;

import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: TODO()
 * @author: zn
 * @date: Created in 2019/10/29 15:51
 * @version:
 */
public class PageUtil {
    /**
     *
     * @Description:TODO(分页对象)
     * @param: page
     * @return:
     * @exception
     * @auther: xushaowen
     * @date: 2019/5/13 13:06
     *
     */
    public static Object pageMap(PageInfo<?> page) {
        Map<String,Object> pageMap = new HashMap<String,Object>();
        pageMap.put("total", page.getTotal());
        pageMap.put("rows", page.getList());
        return pageMap;
    }

    /**
     * @Title: arrayPage
     * @Description: TODO(集合分页)
     * @param pageNumber
     * @param pageSize
     * @author gangyu2
     * @date 2019年5月15日下午3:15:45
     */
    public static SearchResult arrayPage(List list, int pageNumber, int pageSize) throws Exception{
        List pageList = new ArrayList();
        int currIdx = (pageNumber > 1 ? (pageNumber -1) * pageSize : 0);
        for (int i = 0; i < pageSize && i < list.size() - currIdx; i++){
            pageList.add(list.get(currIdx + i));
        }
        SearchResult searchResult = new SearchResult();
        searchResult.setList(pageList);
        searchResult.setTotal(list.size());
        if (searchResult.getTotal()%pageSize == 0){
            searchResult.setPages((int)searchResult.getTotal()/pageSize);
        }else {
            searchResult.setPages((int)searchResult.getTotal()/pageSize + 1);
        }
        searchResult.setPageNum(pageNumber);
        searchResult.setPageSize(pageSize);
        searchResult.setSize(pageList.size());
        //是否是第一页
        if (pageNumber == 1){
            searchResult.setIsFirstPage(true);
        }else {
            searchResult.setIsFirstPage(false);
        }
        //是否是最后一页
        if ((searchResult.getTotal() - pageNumber*pageSize) > 0){
            searchResult.setIsLastPage(false);
        }else {
            searchResult.setIsLastPage(true);
        }
        return searchResult;
    }

    public static class SearchResult {

        private List list;

        private Integer total;

        private Integer pages;

        private Integer pageNum;

        private Integer pageSize;

        private Boolean IsFirstPage;

        private Boolean IsLastPage;

        private Integer size;

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public Boolean getIsLastPage() {
            return IsLastPage;
        }

        public void setIsLastPage(Boolean isLastPage) {
            IsLastPage = isLastPage;
        }

        public List getList() {
            return list;
        }

        public void setList(List list) {
            this.list = list;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getPages() {
            return pages;
        }

        public void setPages(Integer pages) {
            this.pages = pages;
        }

        public Integer getPageNum() {
            return pageNum;
        }

        public void setPageNum(Integer pageNum) {
            this.pageNum = pageNum;
        }

        public Integer getPageSize() {
            return pageSize;
        }

        public void setPageSize(Integer pageSize) {
            this.pageSize = pageSize;
        }

        public Boolean getIsFirstPage() {
            return IsFirstPage;
        }

        public void setIsFirstPage(Boolean isFirstPage) {
            IsFirstPage = isFirstPage;
        }

        @Override
        public String toString() {
            return "SearchResult [list=" + list + ", total=" + total + ", pages=" + pages + ", pageNum=" + pageNum
                    + ", pageSize=" + pageSize + ", IsFirstPage=" + IsFirstPage + ", IsLastPage=" + IsLastPage
                    + ", size=" + size + "]";
        }

    }
}
