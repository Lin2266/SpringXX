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
<context:component-scan base-package="course.spring.di"/>

CDPlayerTest進行單元測試
