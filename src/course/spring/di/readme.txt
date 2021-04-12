使用搜尋和縫合技術自動化DI:
自動化DI的原理與核心標註類別:
spring藉由3個步驟達成自動縫合:
1.元件掃描(component scanning):spring可以自動發現ApplicationContext內的bean元件。
2.自動縫合(auto-wiring):spring將自動建立bean元件間的關聯性(dependency)。
藉由以下4種標註類別(annotation)的搭配使用，spring可以達成上述功能:
1.@Component
2.@Autowired
3.@Configuration
4.@ComponentScan

自動化DI以java設定類別進行
建立MediaPlayer和CompactDisc等2個interface，使用MediaPlayer將可撥放CompactDisc內的曲目，兩者具有相依性:
CompactDiscImpl.java
@Component表示該類別需要被spring建立為bean物件，並列入控管

MediaPlayerImpl.java
@Autowired表示執行時期將自動以需要的bean元件縫合至建構子參數CompactDisc內

AppConfig.java
@Configuration表示該類別為spring設定檔，將建立所有bean物件，及其關聯性。
本列並未如前章範例以@Bean標註bean元件的方法而是改用@ComponentScan。
因而將自動搜尋和本類別在「同一個路徑」或是「所有子路徑」的所有bean類別，並建立物件及注入關聯性。
也可以改用設定檔appConfig.xml取代設定類別AppConfig.java。

appComfig.xml
指定套件以自動搜尋bean類別、建立物件及注入關聯性
<context:component-scan base-package="course.spring.diXML"/>

CDPlayerTest進行單元測試

自動化DI的核心標註類別使用說明:
@Component("beanName")
@Named("beanName")
@componentScan("course.spring.di")

@Component("beanName"):
將該類別名稱的第一個字母改小寫，改變預設名稱
CompactDiscImpl.java範例

@Named("beanName"):
跟@Component("beanName")一樣可以定義bean元件，兩者差別不大

@componentScan("course.spring.di"):
設定類別內可以使用自動搜尋bean元件，預設範圍是設定類別所在套件，及子套件，也可以直接指定搜尋的套件
AppConfig.java範例

@Autowired
Automatic wiring 是指Spring可以自動由容器中找到適合的元件並注入，以滿足與另一個元件的關聯性，意即將DI自動化，
除建構子外，也可在方法、欄位加上@Autowired。
依JSR規格，也可使用「@Inject」代替@Autowired，如同「@Named」取代@Component。
MediaPlayerImpl.java範例

@Bean
AppConfig.java、SoldierConfig.java範例
使用Java設定類別指定元件進行DI，@Bean標註類別指定DI元件:
改用人工明確設定的方式進行DI，以前例自動搜尋的設定類別範例來修改:
1.移除 @componentScan。
2.使用 @Bean 宣告建立bean元件的工廠方法。

在方法上標註@Bean等同告訴spring該方法回傳的物件將註冊為容器管理的bean物件，spring也將自動執行該方法並產出物件，
這類方法如同工廠方法，若有數種bean物件可擇一回傳，spring預設將以「方法名稱」做為「bean物件名稱DI」，
開發者可以自已加上name的屬性覆寫預設名稱:
@Bean("name=myBean")
