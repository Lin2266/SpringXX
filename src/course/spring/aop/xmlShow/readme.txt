XML設定檔定義Aspect(面向)物件
使用annotation的方法定義AOP相關元件相當方便，但前提是必須可以修改程式碼，使用xml設定檔則無此限制。

xml跟annotation 對照關係:

xml							annotation					作用
------------------------------------------------------------------------------------------
<aop:aspectj-autoproxy>		@EnableAspectJAutoProxy		啟用AOP。
<aop:config>				無							是以下標籤的父標籤，有群組化的效果。
<aop:aspect>				@Aspect						定義Aspect(面向)類別。
<aop:pointcut>				@Pointcut					定義pointcut的表示式。
<aop:after>					@After						定義after的Advice(通知)方法。
<aop:after-returning>		@AfterReturning				定義after-returning的Advice(通知)方法。
<aop:after-throwing>		@AfterThrowing				定義after-throwing的Advice(通知)方法。
<aop:around>				@Around						定義around的Advice(通知)方法。
<aop:before>				@Before						定義before的Advice(通知)方法。
<aop:declare-parents>		@DeclareParents				定義Introduction(介紹)相關。