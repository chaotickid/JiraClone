package com.infinity.common.utils;

import com.infinity.common.model.MetaData;
import com.infinity.common.model.UserAuthorizationVM;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.Instant;

@Slf4j
public class Utils {

    public static String getUserFromContext() {
        String userName = StringUtils.EMPTY;
        try {
            userName = ((UserAuthorizationVM) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getEmail();
        } catch (Exception e) {
            log.error("Unable to fetch user name from context, Reason: {}", e.getMessage());
        }
        return userName;
    }

    public static MetaData createMetaData(String type, String status) {
        MetaData metaData = new MetaData();
        String userFromContext = getUserFromContext();
        metaData.setCreatedBy(userFromContext);
        metaData.setCreatedAt(String.valueOf(Instant.now()));
        metaData.setUpdatedBy(userFromContext);
        metaData.setType(type);
        metaData.setStatus(status);
        return metaData;
    }
}