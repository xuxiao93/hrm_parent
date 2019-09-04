package com.xurui.hrm.client;

import com.xurui.hrm.domain.Tenant;
import com.xurui.hrm.query.TenantQuery;
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
public class TenantClientHystrixFallbackFactory implements FallbackFactory<TenantClient> {

    @Override
    public TenantClient create(Throwable throwable) {
        return new TenantClient() {
            @Override
            public AjaxResult save(Tenant tenant) {
                return null;
            }

            @Override
            public AjaxResult delete(Integer id) {
                return null;
            }

            @Override
            public Tenant get(Long id) {
                return null;
            }

            @Override
            public List<Tenant> list() {
                return null;
            }

            @Override
            public PageList<Tenant> json(TenantQuery query) {
                return null;
            }
        };
    }
}
