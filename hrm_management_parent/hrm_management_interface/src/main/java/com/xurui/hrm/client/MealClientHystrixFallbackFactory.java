package com.xurui.hrm.client;

import com.xurui.hrm.domain.Meal;
import com.xurui.hrm.query.MealQuery;
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
public class MealClientHystrixFallbackFactory implements FallbackFactory<MealClient> {

    @Override
    public MealClient create(Throwable throwable) {
        return new MealClient() {
            @Override
            public AjaxResult save(Meal meal) {
                return null;
            }

            @Override
            public AjaxResult delete(Integer id) {
                return null;
            }

            @Override
            public Meal get(Long id) {
                return null;
            }

            @Override
            public List<Meal> list() {
                return null;
            }

            @Override
            public PageList<Meal> json(MealQuery query) {
                return null;
            }
        };
    }
}
