第八章 使用Spring web flow
    本章内容：
        1、创建会话式的web应用程序
        2、定义流程状态和行为
        3、保护web流程
    8.1 在Spring中配置 Web Flow
        现在还不支持在java中配置Spring Web Flow，只能在XML中对其进行配置。配置xml的头信息。
        8.1.1 装配流程执行器（flow executor）
            <flow:flow-executor id="flowExecutor"/>元素会创建一个流程执行器。
        8.1.2 配置流程注册表（flow registry）
        8.1.3 处理流程请求
    8.2 流程的组件
        在Spring Web Flow中流程是由三个主要元素定义的：状态(state)、转移(transition)和流程数据。
        8.2.1 State
            Spring Web Flow 定义了五种不同类型的状态：Action, Decision, End, Subflow, View
            View State
                id在流程内标示这个状态
                <view-state id="welcome"/>
                <view-state id="welcome" view="grwting"/>
                <view-state id="takePayment" model="flowse.paymentDetails"/>
            Action State
                <action-state id="saveOrder">
                    <evaluate expression="pizzaFlowAcrtions.saveOrder(order)"/>
                    <transition to="thankYou"/>
                </action-state>
            Decision State
                <decision-state id="checkDeliveryArea">
                    <if test="pizzaFlowActions.checkDeliveryArea(customer.zipCode)"
                        then="addCustomer"
                        else="deliveryWarning"/>
                </decision-state>
            SubFlow State
                <subflow-state id="order" subflow="pizza/order">
                    <input name="order" value="order"/>
                    <transition on="orderCreated" to="payment"/>
                </subflow-state>
            End State
                <end-state id="customerReady"/>
        8.2.2 Transition
            <transition to="customerReady"/>
            <transition on="phoneEntered" to="lookupCustomer"/>
            <transition on-exception="com.springinaction.pizza.service.CustomerNotFoundException" to="registration"/>
            全局转移
                <global-transitions>
                    <transition on="cancel" to="endstate"/>
                </global-transitions>
        8.2.3 Flow Data
            声明变量
                <var name="customer" class="com.springinaction.pizza.domain.Customer"/>
                <evaluate result="viewScope.toppingsList" expression="T(com.springinaction.pizza.domain.Topping).asList()"/>
                <set name="flowScope.pizza" value="new com.springinaction.pizza.domain.Pizza()"/>
            定义流程数据的作用域
                Spring Web Flow定义了五种不同的作用域：Conversation, Flow,  Request, Flash, View
    8.3 组合起来：披萨流程
        8.3.1 定义基本流程
        8.3.2 收集顾客信息
            询问电话号码
            查找客户
            注册新的用户
            存储顾客数据
            结束流程
        8.3.3 构建订单
        8.3.4 支付
    8.4 保护 Web Flow
    8.5 小结

