package com.xurui.hrm.client;


import com.xurui.hrm.domain.Pager;
import com.xurui.hrm.query.PagerQuery;
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
public class PagerClientHystrixFallbackFactory implements FallbackFactory<PagerClient> {

    @Override
    public PagerClient create(Throwable throwable) {
        return new PagerClient() {
            @Override
            public AjaxResult save(Pager pager) {
                return null;
            }

            @Override
            public AjaxResult delete(Integer id) {
                return null;
            }

            @Override
            public Pager get(Long id) {
                return null;
            }

            @Override
            public List<Pager> list() {
                return null;
            }

            @Override
            public PageList<Pager> json(PagerQuery query) {
                return null;
            }
        };
    }
}
