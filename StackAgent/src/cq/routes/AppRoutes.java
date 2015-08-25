package cq.routes;

import cq.action.TestAction;
import cq.core.action.BaseAction;
import cq.core.route.RouteMap;

/**
 * 测试用例
 * 
 * @author chenqing24@163.com
 */
public class AppRoutes extends RouteMap {

    @Override
    protected void map() {
        get("/", new BaseAction() {
            @Override
            public void run() {
                print("Hello World!");
            }
        });
        
        get("/hi", new TestAction());
    }

}