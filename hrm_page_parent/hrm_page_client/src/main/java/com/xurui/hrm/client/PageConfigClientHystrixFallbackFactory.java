package com.xurui.hrm.client;


import com.xurui.hrm.domain.PageConfig;
import com.xurui.hrm.query.PageConfigQuery;
import com.xurui.hrm.util.AjaxResult;
import com.xurui.hrm.util.PageList;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yaohuaipeng
 * @date 2018/10/8-16:18
 */
@Component
public class PageConfigClientHystrixFallbackFactory implements FallbackFactory<PageConfigClient> {

    @Override
    public PageConfigClient create(Throwable throwable) {
        return new PageConfigClient() {
            @Override
            public AjaxResult save(PageConfig pageConfig) {
                return null;
            }

            @Override
            public AjaxResult delete(Integer id) {
                return null;
            }

            @Override
            public PageConfig get(Long id) {
                return null;
            }

            @Override
            public List<PageConfig> list() {
                return null;
            }

            @Override
            public PageList<PageConfig> json(PageConfigQuery query) {
                return null;
            }
        };
    }
}
