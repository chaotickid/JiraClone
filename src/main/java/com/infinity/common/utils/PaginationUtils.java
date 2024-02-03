package com.infinity.common.utils;

import com.infinity.jiramanagement.model.view.PaginationVM;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class PaginationUtils<T> {

    public List<T> filterPagination(List<T> incomingList, PaginationVM paginationVM) {
        log.debug("filtration triggered => [ IN_PROGRESS ]");
        int offset = paginationVM.getOffset() != null ? paginationVM.getOffset() : 0;
        int limit = paginationVM.getLimit() != null ? paginationVM.getLimit() : incomingList.size();
        List<T> newFilteredList = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < incomingList.size(); i++) {
            if (i < offset) {
                continue;
            }
            if(count >= limit){
                break;
            }
            newFilteredList.add(incomingList.get(i));
            count++;
        }
        return newFilteredList;
    }

}