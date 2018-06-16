package com.keji.contest.config;

import com.keji.contest.model.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lizehua035 on 2018/6/9.
 */
public class UserContext {
        protected static final Logger logger = LoggerFactory.getLogger(UserContext.class);
        private ThreadLocal<UserContext> userRequestThread = new ThreadLocal<UserContext>();
        private ThreadLocal<Map<String, Object>> userParameter = new ThreadLocal<Map<String, Object>>();
        private static final UserContext instance = new UserContext();

        public static void setUserParameter(String key, Object value) {
            logger.debug(String.format("Set the user [%s,%s] to thread local", key, value));
            if(getInstance().userParameter.get() == null) {
                getInstance().userParameter.set(new HashMap<String, Object>());
            }
            Map<String, Object> map = getInstance().userParameter.get();
            map.put(key, value);
        }
        public static Object getUserParameter(String key) {
            if(getInstance().userParameter.get() == null) {
                getInstance().userParameter.set(new HashMap<String, Object>());
            }
            return getInstance().userParameter.get().get(key);
        }

        private static UserContext getInstance() {
            return instance;
        }

        public final static UserContext getCurrentUserContext() {
            return getInstance().userRequestThread.get();
        }

        public final static void setCurrentUserContext(final UserContext userContext) {
            logger.debug("Set the user context to thread local");
            getInstance().userRequestThread.set(userContext);
        }

        public final static void removeCurrentUserContext() {
            logger.debug("Remove the thread local");
            getInstance().userRequestThread.remove();
            getInstance().userParameter.remove();
        }

    public final static void setUser(UserDTO userDTO){
        setUserParameter("currentUser",userDTO);
    }

    public final static UserDTO getUser(){
      return (UserDTO)getUserParameter("currentUser");
    }
}
