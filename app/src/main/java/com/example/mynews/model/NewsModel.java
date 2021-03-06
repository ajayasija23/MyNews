package com.example.mynews.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsModel {

    /**
     * status : ok
     * totalResults : 38
     * articles : [{"source":{"id":"google-news","name":"Google News"},"author":null,"title":"Ex-NFL player kills himself after killing 5, injuring 1 in South Carolina, police say | Nightline - ABC News","description":null,"url":"https://news.google.com/__i/rss/rd/articles/CBMiK2h0dHBzOi8vd3d3LnlvdXR1YmUuY29tL3dhdGNoP3Y9Z0pLN3ZEMXVrQzjSAQA?oc=5","urlToImage":null,"publishedAt":"2021-04-09T08:29:14Z","content":null},{"source":{"id":"the-verge","name":"The Verge"},"author":"Jon Porter","title":"Apple says iMessage on Android \u2018will hurt us more than help us\u2019 - The Verge","description":"Apple knows that iMessage\u2019s blue bubbles are a big barrier to people switching to Android, which is why the service has never appeared on Google\u2019s mobile operating system. That\u2019s according to a court filing from Epic Games.","url":"https://www.theverge.com/2021/4/9/22375128/apple-imessage-android-ecosystem-lock-in-epic-games-filings-app-store-dispute","urlToImage":"https://cdn.vox-cdn.com/thumbor/F-P2CCD4JiJX36uzKvo5amS95RU=/0x146:2040x1214/fit-in/1200x630/cdn.vox-cdn.com/uploads/chorus_asset/file/16278272/akrales_190513_3338_0008_2.jpg","publishedAt":"2021-04-09T08:27:39Z","content":"Epic argues its part of Apples lock-in strategy\r\nPhoto by Amelia Holowaty Krales / The Verge\r\nApple knows that iMessages blue bubbles are a big barrier to people switching to Android, which is why th\u2026 [+2170 chars]"},{"source":{"id":"associated-press","name":"Associated Press"},"author":null,"title":"Rioters ignore pleas for calm as violence flares in Belfast - Associated Press","description":"BELFAST (AP) \u2014 Gangs of youths threw stones and fireworks at police in Belfast who hit back with water cannons as violence flared again on the streets of Northern Ireland. Unrest has erupted...","url":"https://apnews.com/article/joe-biden-belfast-boris-johnson-northern-ireland-violence-5741c1a1efd11f1ec7d53bf6940ce079","urlToImage":"https://storage.googleapis.com/afs-prod/media/c8a83b51bf034222ae094192087e5371/3000.jpeg","publishedAt":"2021-04-09T08:11:08Z","content":"BELFAST (AP) Gangs of youths threw stones and fireworks at police in Belfast who hit back with water cannons as violence flared again on the streets of Northern Ireland.\r\nUnrest has erupted over the \u2026 [+1693 chars]"},{"source":{"id":"al-jazeera-english","name":"Al Jazeera English"},"author":"Al Jazeera","title":"Nike ends lawsuit over \u2018Satan Shoes\u2019 after New York firm recall - Al Jazeera English","description":"Nike had sued maker of devil-themed sneaker promoted by rapper Lil Nas X for trademark infringement.","url":"https://www.aljazeera.com/economy/2021/4/9/nike-ends-lawsuit-over-satan-shoes-after-new-york-firm-recall","urlToImage":"https://www.aljazeera.com/wp-content/uploads/2021/03/Screen-Shot-2021-03-30-at-1.59.56-PM-1.jpg?resize=1000%2C630","publishedAt":"2021-04-09T07:44:53Z","content":"Nike Inc says a Brooklyn company that made Satan Shoes in collaboration with rapper Lil Nas X has agreed to voluntarily recall the footwear, as part of a legal settlement with the athletics giant.\r\nT\u2026 [+1812 chars]"},{"source":{"id":"the-washington-post","name":"The Washington Post"},"author":"Erin Cunningham","title":"Covid-19 live updates: U.S. cases involving Brazil variant on the rise, according to CDC data - The Washington Post","description":"More than 30 million people have been infected with the coronavirus in the United States and over 559,000 have died.","url":"https://www.washingtonpost.com/nation/2021/04/09/coronavirus-covid-live-updates-us/","urlToImage":"https://www.washingtonpost.com/wp-apps/imrs.php?src=https://arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/46BABEUY2II6XDYKGOCM6T5TTE.jpg&w=1440","publishedAt":"2021-04-09T07:20:00Z","content":"The more virulent coronavirus variant that originated in Brazil now accounts for at least 434 infections in the United States, according to new data from the U.S. Centers for Disease Control and Prev\u2026 [+1360 chars]"},{"source":{"id":"usa-today","name":"USA Today"},"author":"Susan Page","title":"Exclusive: How Donald Trump upended Nancy Pelosi\u2019s plans, then she unraveled his - USA TODAY","description":"The election she thought would be the end of her career became the beginning of its most consequential chapter: Defying a 'scary' president","url":"https://www.usatoday.com/in-depth/news/politics/2021/04/09/bracing-battle-inside-nancy-pelosis-war-donald-trump/7053833002/","urlToImage":"https://www.gannett-cdn.com/presto/2021/03/17/USAT/c2a6a085-2778-4ec7-9649-a57057c858fc-Madam_Speaker.jpg?crop=446,251,x0,y0&width=1200","publishedAt":"2021-04-09T07:00:04Z","content":"This story is adapted from??\u201cMadam Speaker: Nancy Pelosi and the Lessons of Power,\u201d which will be published April 20 by Twelve Books. Author Susan Page, the Washington Bureau chief of USA TODAY, condu\u2026 [+27475 chars]"},{"source":{"id":null,"name":"NPR"},"author":"","title":"Threat Of Volcanic Eruption Forces Residents To Flee St. Vincent - NPR","description":"Saint Vincent's National Emergency Management Organization raised the island's alert to red on Thursday, after days of increased seismic activity at the La Soufriere volcano.","url":"https://www.npr.org/2021/04/09/985626157/threat-of-volcanic-eruption-forces-residents-to-flee-st-vincent","urlToImage":"https://media.npr.org/assets/img/2021/04/09/gettyimages-945274688_wide-09814f3d868e170fbb93dcf9cf3336998bcb7dcd.jpg?s=1400","publishedAt":"2021-04-09T06:58:13Z","content":"La Soufriere volcano in Saint Vincent.\r\nJean-Marc Lecerf /Gamma-Rapho via Getty Images\r\nA volcano on the eastern Caribbean island of St. Vincent is threatening to erupt, triggering a mandatory emerge\u2026 [+2195 chars]"},{"source":{"id":null,"name":"New York Times"},"author":"Tiffany May","title":"It\u2019s All a Blur: Chinese Shows Censor Western Brands Over Xinjiang Dispute - The New York Times","description":"Online platforms that stream dance, singing and comedy shows are pixelating performers\u2019 T-shirts and sneakers amid a nationalistic fervor.","url":"https://www.nytimes.com/2021/04/09/world/asia/china-blur-brands-xinjiang-cotton.html","urlToImage":"https://static01.nyt.com/images/2021/04/09/world/09china-blur-1/09china-blur-1-facebookJumbo.jpg","publishedAt":"2021-04-09T06:02:11Z","content":"Other shows executed similar blurring feats in postproduction. Contestants on another reality show for entertainers, Sisters Who Make Waves, practiced cartwheels in sneakers blitzed into indiscernibl\u2026 [+1823 chars]"},{"source":{"id":"cnn","name":"CNN"},"author":"Ashley Strickland, CNN","title":"Russian cosmonauts, NASA astronaut launch to the space station - CNN","description":"NASA astronaut Mark Vande Hei and Roscosmos cosmonauts Oleg Novitskiy and Pyotr Dubrov will launch to the International Space Station from the Baikonur Cosmodrome in Kazakhstan Friday. This means the floating laboratory will be home to 10 people.","url":"https://www.cnn.com/2021/04/09/world/nasa-space-station-launch-expedition-65-scn/index.html","urlToImage":"https://cdn.cnn.com/cnnnext/dam/assets/210407170007-01-expedition-65-crew-0320-super-tease.jpeg","publishedAt":"2021-04-09T05:18:00Z","content":null},{"source":{"id":null,"name":"Gizmodo.com"},"author":"Alyse Stanley","title":"Samsung's Upgraded Smart Tracker Can Help You Find Your Keys Using AR - Gizmodo","description":"On Thursday, Samsung announced plans to launch an upgraded version of its Galaxy SmartTag smart trackers, the aptly named SmartTag+, globally on April 16 with a U.S. rollout expected sometime \u201cin the coming weeks.\u201d","url":"https://gizmodo.com/samsungs-upgraded-smart-trackers-can-help-you-find-your-1846648424","urlToImage":"https://i.kinja-img.com/gawker-media/image/upload/c_fill,f_auto,fl_progressive,g_center,h_675,pg_1,q_80,w_1200/cgj8dijknypkpepbolm7.jpg","publishedAt":"2021-04-09T04:52:34Z","content":"On Thursday, Samsung announced plans to launch an upgraded version of its Galaxy SmartTag smart trackers, the aptly named SmartTag+, globally on April 16 with a U.S. rollout expected sometime in the \u2026 [+2621 chars]"},{"source":{"id":"politico","name":"Politico"},"author":"Nancy Vu","title":"Kinzinger calls for Gaetz to resign - POLITICO","description":"Rep. Adam Kinzinger called for his fellow Republican lawmaker to resign Thursday night.","url":"https://www.politico.com/news/2021/04/09/kinzinger-gaetz-resign-480535","urlToImage":"https://static.politico.com/7d/59/bced07de437aa383c42e8e5efd1a/4-8-21-kinzinger-ap-773.jpg","publishedAt":"2021-04-09T04:01:48Z","content":"All you have to do is see people like, of course, Marjorie Taylor Greene. You look at people like Matt Gaetz, who know better. I think neither of them believes the stuff they ascribe to, they just wa\u2026 [+1064 chars]"},{"source":{"id":"google-news","name":"Google News"},"author":null,"title":"Taylor Swift - Breathe (Taylor's Version) (Lyric Video) ft. Colbie Caillat - TaylorSwiftVEVO","description":null,"url":"https://news.google.com/__i/rss/rd/articles/CBMiK2h0dHBzOi8vd3d3LnlvdXR1YmUuY29tL3dhdGNoP3Y9cXNVSy1CRzVPUVHSAQA?oc=5","urlToImage":null,"publishedAt":"2021-04-09T04:00:30Z","content":null},{"source":{"id":null,"name":"KCRA Sacramento"},"author":null,"title":"New Avengers campus coming to Disneyland Resort this summer - KCRA Sacramento","description":"Avengers assemble! Disneyland resort announces new campus opening in June","url":"https://www.kcra.com/article/new-avengers-campus-disneyland-resort-this-summer/36068132","urlToImage":"https://kubrick.htvapps.com/htv-prod-media.s3.amazonaws.com/images/avengers2-1617940418.jpg?crop=1.00xw:1.00xh;0,0&resize=1200:*","publishedAt":"2021-04-09T03:57:00Z","content":"ANAHEIM, Calif. \u2014The Avengers are coming to Disneyland Resort and Disney California Adventure park this summer, officials announced Thursday. \r\nThe new Avengers Campus will open its doors on Jun. 4, \u2026 [+1208 chars]"},{"source":{"id":null,"name":"hot97.com"},"author":null,"title":"UPDATE: DMX Is Still On Life Support; Online Rumors Of His Passing Are 'False' - Hot97 - Hip Hop & R&B News","description":"This evening, rumors exploded on the internet that DMX had officially passed away after fighting for his life a week after being rushed to the hospital following a reported overdose. Rumors apparently came from a now deleted","url":"https://www.hot97.com/hip-hop-news/hot-news/dmx-is-still-on-life-support-online-rumors-of-his-passing-are-false/","urlToImage":"https://dehayf5mhw1h7.cloudfront.net/wp-content/uploads/sites/1300/2021/04/03124436/SummerJamDMX.jpg","publishedAt":"2021-04-09T03:48:35Z","content":null},{"source":{"id":"fox-news","name":"Fox News"},"author":"Charles Creitz","title":"Sen. Hawley: Biden ultimately seeks civilian gun confiscation, while permitting rioters and crime - Fox News","description":"Sen. Josh Hawley, R-Mo., said Thursday that President Biden sent the message earlier in the day that he has no regard for the Second Amendment despite words to the contrary, while it is evident gun confiscation is the true endgame for him.","url":"https://www.foxnews.com/politics/sen-hawley-biden-ultimately-seeks-civilian-gun-confiscation-while-permitting-rioters-and-crime","urlToImage":"https://static.foxnews.com/foxnews.com/content/uploads/2021/04/biden.jpg","publishedAt":"2021-04-09T03:31:14Z","content":"Sen. Josh Hawley, R-Mo., said Thursday that President Biden sent the message earlier in the day that he has no regard for the Second Amendment despite words to the contrary, while it is evident gun c\u2026 [+2506 chars]"},{"source":{"id":"usa-today","name":"USA Today"},"author":"Kelly Tyko","title":"Is Facebook down? Instagram and Facebook experienced a brief outage Thursday due to 'configuration change' - USA TODAY","description":"Facebook and Instagram experienced an outage Thursday afternoon. Service was quickly restored and users of the platforms jumped to Twitter to vent.","url":"https://www.usatoday.com/story/tech/2021/04/08/facebook-instagram-outage-april-2021/7147860002/","urlToImage":"https://www.gannett-cdn.com/-mm-/58483d27bd366f68e9d1453517c689fd251cf7c4/c=116-0-1142-577/local/-/media/2020/05/19/USATODAY/usatsports/MotleyFool-TMOT-9fdfb8f1-fb-logo-big.png?width=1600&height=800&fit=crop","publishedAt":"2021-04-09T03:00:00Z","content":"The common theme of social media outages is to jump on another network to vent.\r\nAs with??nearly every Facebook and Instagram outage, users headed to Twitter on Thursday with the hashtag #InstagramDow\u2026 [+2222 chars]"},{"source":{"id":"cnn","name":"CNN"},"author":"Manu Raju, Jeremy Herb and Evan Perez, CNN","title":"First GOP member of Congress calls on Matt Gaetz to resign - CNN","description":"Illinois Rep. Adam Kinzinger became the first congressional Republican to call on his colleague from Florida, Rep. Matt Gaetz, to resign in the face of a federal investigation into sex trafficking allegations.","url":"https://www.cnn.com/2021/04/08/politics/adam-kinzinger-matt-gaetz-house-republicans/index.html","urlToImage":"https://cdn.cnn.com/cnnnext/dam/assets/210408164153-06-gaetz-file-2019-super-tease.jpg","publishedAt":"2021-04-09T02:42:00Z","content":"(CNN)Illinois Rep. Adam Kinzinger became the first congressional Republican to call on his colleague from Florida, Rep. Matt Gaetz, to resign in the face of a federal investigation into sex trafficki\u2026 [+2688 chars]"},{"source":{"id":null,"name":"WRAL.com"},"author":"Kirsten Guti??rrez, Julian Grace, Brad Simmons, Luke Notestine, Sydney Franklin","title":"CDC finds no safety issues, recommends J&J vaccines continue to be administered at PNC Arena after adverse... - WRAL.com","description":"Johnson & Johnson COVID-19 vaccinations were paused at PNC Arena in Raleigh on Thursday after \"several people\" had adverse reactions, according to spokeswoman Stacy Beard.","url":"https://www.wral.com/covid-19-vaccine-clinics-put-j-j-vaccine-on-hold-after-adverse-reactions-cdc-finds-no-safety-issue-with-vaccine/19616960/","urlToImage":"https://wwwcache.wral.com/asset/news/local/2021/02/05/19511831/111374-pnc-DMID1-5ps1u0j9g-640x480.jpg","publishedAt":"2021-04-09T02:28:41Z","content":"By WRAL News\r\nRaleigh, N.C. \u2014 Several COVID-19 vaccine providers have stopped administering the Johnson &amp; Johnson vaccine after a few adverse reactions were reported on Thursday.\r\nWake County spo\u2026 [+5373 chars]"},{"source":{"id":null,"name":"KGW.com"},"author":"Pat Dooris","title":"Oregon has 4th-lowest number of COVID cases per 100K people in the country - KGW.com","description":"Oregon has reported 3,962 cases for every 100,000 residents.","url":"https://www.kgw.com/article/news/health/coronavirus/oregon-has-4th-lowest-number-of-covid-cases-per-100k-people/283-e5264d8f-be8b-4e46-9543-6c600f9465c0","urlToImage":"https://media.kgw.com/assets/KGW/images/833504bf-450a-4911-860f-14f9e57b90fe/833504bf-450a-4911-860f-14f9e57b90fe_1140x641.jpg","publishedAt":"2021-04-09T01:37:00Z","content":"PORTLAND, Oregon The Oregon Health Authority (OHA) said the states number of COVID-19 cases per 100,000 people is the fourth-lowest in the country.\r\nSince the pandemic began, the state has counted mo\u2026 [+2736 chars]"},{"source":{"id":"techcrunch","name":"TechCrunch"},"author":"Darrell Etherington","title":"Watch a monkey equipped with Elon Musk\u2019s Neuralink device play Pong with its brain - TechCrunch","description":"Elon Musk\u2019s Neuralink, one of his many companies and the only one currently focused on mind control (that we\u2019re aware of), has released a new blog post and video detailing some of its recent updates \u2014 including using its hardware to make it possible for a mon\u2026","url":"http://techcrunch.com/2021/04/08/watch-a-monkey-equipped-with-elon-musks-neuralink-device-play-pong-with-its-brain/","urlToImage":"https://techcrunch.com/wp-content/uploads/2021/04/elon-monkey-brain-pong.gif?w=713","publishedAt":"2021-04-09T01:31:41Z","content":"Elon Musk\u2019s Neuralink, one of his many companies and the only one currently focused on mind control (that we\u2019re aware of), has released a new blog post and video detailing some of its recent updates \u2026 [+2541 chars]"}]
     */

    @SerializedName("status")
    private String status;
    @SerializedName("totalResults")
    private int totalResults;
    @SerializedName("articles")
    private List<ArticlesBean> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<ArticlesBean> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticlesBean> articles) {
        this.articles = articles;
    }

    public static class ArticlesBean {
        /**
         * source : {"id":"google-news","name":"Google News"}
         * author : null
         * title : Ex-NFL player kills himself after killing 5, injuring 1 in South Carolina, police say | Nightline - ABC News
         * description : null
         * url : https://news.google.com/__i/rss/rd/articles/CBMiK2h0dHBzOi8vd3d3LnlvdXR1YmUuY29tL3dhdGNoP3Y9Z0pLN3ZEMXVrQzjSAQA?oc=5
         * urlToImage : null
         * publishedAt : 2021-04-09T08:29:14Z
         * content : null
         */

        @SerializedName("source")
        private SourceBean source;
        @SerializedName("author")
        private String author;
        @SerializedName("title")
        private String title;
        @SerializedName("description")
        private String description;
        @SerializedName("url")
        private String url;
        @SerializedName("urlToImage")
        private String urlToImage;
        @SerializedName("publishedAt")
        private String publishedAt;
        @SerializedName("content")
        private String content;

        public SourceBean getSource() {
            return source;
        }

        public void setSource(SourceBean source) {
            this.source = source;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrlToImage() {
            return urlToImage;
        }

        public void setUrlToImage(String urlToImage) {
            this.urlToImage = urlToImage;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public static class SourceBean {
            /**
             * id : google-news
             * name : Google News
             */

            @SerializedName("id")
            private String id;
            @SerializedName("name")
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
