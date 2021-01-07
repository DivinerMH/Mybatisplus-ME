package com.helper.constant;

/**
 * 业务常量
 *
 * @author bjx
 * @date 2020-04-20
 */
public interface BusinessConstants {

    interface Entrance {
        /**
         * From
         */
        interface From {
            /**
             * 外访
             */
            String VISITORS = "visitors";

            /**
             * 用户
             */
            String ADMIN = "admin";
        }
    }

    /**
     * 外访
     */
    interface Visitors {
        /**
         * 外访申请类型
         */
        interface OutboundType {
            /**
             * 外部
             */
            String OUT_TYPE = "0";

            /**
             * 内部邀请
             */
            String INTERNAL_TYPE = "1";

            /**
             * 临时访问
             */
            String TEMP_TYPE = "2";
        }

        /**
         * 外访用户详情
         */
        interface OutboundDetail {
            /**
             * 主访客
             */
            String IS_MAIN = "1";
        }

        /**
         * 内部邀请
         */
        interface OutboundInvite {
            /**
             * 未提交
             */
            String STATUS_ZERO = "0";

            /**
             * 已提交
             */
            String STATUS_ONE = "1";
        }

        /**
         * 外访记录
         */
        interface OutboundRecording {
            /**
             * 进
             */
            String STATUS_IN = "0";

            /**
             * 出
             */
            String STATUS_OUT = "1";
        }
    }
}
