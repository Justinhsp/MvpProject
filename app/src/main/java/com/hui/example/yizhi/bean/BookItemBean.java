package com.hui.example.yizhi.bean;

import java.util.List;

public class BookItemBean {


        /**
         * rating : {"max":10,"numRaters":99914,"average":"8.6","min":0}
         * subtitle :
         * author : ["刘瑜"]
         * pubdate : 2010-1
         * tags : [{"count":31891,"name":"刘瑜","title":"刘瑜"},{"count":27146,"name":"随笔","title":"随笔"},{"count":14784,"name":"送你一颗子弹","title":"送你一颗子弹"},{"count":8903,"name":"杂七杂八","title":"杂七杂八"},{"count":8074,"name":"时评","title":"时评"},{"count":6209,"name":"文化","title":"文化"},{"count":5594,"name":"中国文学","title":"中国文学"},{"count":5048,"name":"中国","title":"中国"}]
         * origin_title :
         * image : https://img1.doubanio.com/view/subject/m/public/s4243447.jpg
         * binding : 平装
         * translator : []
         * catalog : 论他人即地狱
         渊博的人
         积极的人
         另一个高度
         What Is He Building There?
         自然
         另一个博客
         你比你想象的更自由
         词语洁癖
         红唇
         厨房政治
         Intimacy
         有关的无关的人
         他们学理工的
         集体早操
         煽情的艺术
         诗坛风乍起
         周末读物
         论自己作为他人
         学习焦虑
         对猪头肉的乡愁
         过去的理想
         干一行，恨一行
         谢谢收看
         Alice
         老张、亦文和蚊米
         我爱“饭扫光”
         纽约客
         与崔健有关的日子
         开头
         1路地铁
         甜蜜的恐怖
         非正式疯狂
         毛姆
         乱
         裙子
         技术问题
         缺乏弹性的人
         七年之后
         Slow like Honey
         我想乘一艘慢船去……
         开学了
         论人生意义之不可知
         人生缩影
         被搁置的生活
         解决
         无用功
         逃避自由
         请别让我消失
         吞下那颗红药丸
         回到巴黎
         买了一堆意义
         一天长一点
         娜拉出国之后
         老鼠与上帝
         25个箱子
         世相
         小芳
         飞越流水线
         雪花点
         形而下生活
         一个人要像一支队伍
         记一次邪教活动
         长达五分钟的爱意
         在死亡的强光中
         论爱情之不可能
         园丁与花园
         约会文化
         Hello，Stranger
         已经太晚
         爱情饥渴症
         你所能想到的全部理由
         独身主义
         求婚
         这个，那个以及其他的
         爱是
         没有人比我更懂你
         电视里的爱情
         Crush
         欲望都市
         兔子跑什么跑
         色
         但是不要只是因为你是女人
         最好的时光
         论婚姻制度的演进趋势
         论社会之既不可知又不可能
         当他们开始用脚投票
         未来世界
         心型卡片
         自我一代
         那个搬起石头砸自己脚的人
         道德极限
         超越那一天
         奢侈生活
         政治的尽头
         They Just Give Up
         送你一颗子弹
         在祖国的怀抱里
         没有你们就没有他们
         匈牙利咖啡馆
         Life after People
         学术辩论
         制度主义
         牛校牛在哪
         五个女博士
         在不可能与不可能之间
         后记
         * pages : 339
         * images : {"small":"https://img1.doubanio.com/view/subject/s/public/s4243447.jpg","large":"https://img1.doubanio.com/view/subject/l/public/s4243447.jpg","medium":"https://img1.doubanio.com/view/subject/m/public/s4243447.jpg"}
         * alt : https://book.douban.com/subject/4238362/
         * id : 4238362
         * publisher : 上海三联书店
         * isbn10 : 7542631667
         * isbn13 : 9787542631664
         * title : 送你一颗子弹
         * url : https://api.douban.com/v2/book/4238362
         * alt_title :
         * author_intro : Drunk Piano，生于1975年12月。毕业于中国人民大学，政治学博士，现执教于剑桥大学。小说、随笔、政治评论散见于《芙蓉》、《希望》、《南风窗》、《外滩画刊》。曾以DrunkPiano网名在某海外网站，连载其主要小说作品。
         * summary : 这本书里记录的是作者2005—2009年左右(尤其是2006—2007年)生活里的点点滴滴。在这本书里，被“审视”的东西杂七杂八，有街上的疯老头，有同宿舍的室友，有爱情、电影和书，大到制度，小到老鼠。由于我写这些东西的时候，出发点并不是写一本书，所以不同文章往往风格迥异，长短不一，质量不均，随着社会形势、荷尔蒙周期以及我逃避生活的力度而起伏。
         * series : {"id":"12374","title":"刘瑜作品系列"}
         * price : 25.00元
         * ebook_url : https://read.douban.com/ebook/1362753/
         * ebook_price : 6.00
         */

        private RatingBean rating;
        private String subtitle;
        private String pubdate;
        private String origin_title;
        private String image;
        private String binding;
        private String catalog;
        private String pages;
        private ImagesBean images;
        private String alt;
        private String id;
        private String publisher;
        private String isbn10;
        private String isbn13;
        private String title;
        private String url;
        private String alt_title;
        private String author_intro;
        private String summary;
        private SeriesBean series;
        private String price;
        private String ebook_url;
        private String ebook_price;
        private List<String> author;
        private List<TagsBean> tags;
        private List<?> translator;

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getPubdate() {
            return pubdate;
        }

        public void setPubdate(String pubdate) {
            this.pubdate = pubdate;
        }

        public String getOrigin_title() {
            return origin_title;
        }

        public void setOrigin_title(String origin_title) {
            this.origin_title = origin_title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getBinding() {
            return binding;
        }

        public void setBinding(String binding) {
            this.binding = binding;
        }

        public String getCatalog() {
            return catalog;
        }

        public void setCatalog(String catalog) {
            this.catalog = catalog;
        }

        public String getPages() {
            return pages;
        }

        public void setPages(String pages) {
            this.pages = pages;
        }

        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public String getIsbn10() {
            return isbn10;
        }

        public void setIsbn10(String isbn10) {
            this.isbn10 = isbn10;
        }

        public String getIsbn13() {
            return isbn13;
        }

        public void setIsbn13(String isbn13) {
            this.isbn13 = isbn13;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAlt_title() {
            return alt_title;
        }

        public void setAlt_title(String alt_title) {
            this.alt_title = alt_title;
        }

        public String getAuthor_intro() {
            return author_intro;
        }

        public void setAuthor_intro(String author_intro) {
            this.author_intro = author_intro;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public SeriesBean getSeries() {
            return series;
        }

        public void setSeries(SeriesBean series) {
            this.series = series;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getEbook_url() {
            return ebook_url;
        }

        public void setEbook_url(String ebook_url) {
            this.ebook_url = ebook_url;
        }

        public String getEbook_price() {
            return ebook_price;
        }

        public void setEbook_price(String ebook_price) {
            this.ebook_price = ebook_price;
        }

        public List<String> getAuthor() {
            return author;
        }

        public void setAuthor(List<String> author) {
            this.author = author;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public List<?> getTranslator() {
            return translator;
        }

        public void setTranslator(List<?> translator) {
            this.translator = translator;
        }

        public static class RatingBean {
            /**
             * max : 10
             * numRaters : 99914
             * average : 8.6
             * min : 0
             */

            private int max;
            private int numRaters;
            private String average;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public int getNumRaters() {
                return numRaters;
            }

            public void setNumRaters(int numRaters) {
                this.numRaters = numRaters;
            }

            public String getAverage() {
                return average;
            }

            public void setAverage(String average) {
                this.average = average;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class ImagesBean {
            /**
             * small : https://img1.doubanio.com/view/subject/s/public/s4243447.jpg
             * large : https://img1.doubanio.com/view/subject/l/public/s4243447.jpg
             * medium : https://img1.doubanio.com/view/subject/m/public/s4243447.jpg
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }

        public static class SeriesBean {
            /**
             * id : 12374
             * title : 刘瑜作品系列
             */

            private String id;
            private String title;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }

        public static class TagsBean {
            /**
             * count : 31891
             * name : 刘瑜
             * title : 刘瑜
             */

            private int count;
            private String name;
            private String title;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }


    /**
     * 获取Author字符串
     *
     * @return Author字符串 A/B/C..
     */
    public String getAuthorsString() {
        return sListToString(getAuthor());
    }

    /**
     * 格式化list为字符串
     *
     * @param list 类型list
     * @return 字符串 A/B/C..
     */
    private String sListToString(List<String> list) {
        String str = "";
        if (list.size() == 0)
            return str;
        for (int i = 0; i < list.size(); i++) {
            str = str + list.get(i);
            if (i < list.size() - 1)
                str += " / ";
        }
        return str;
    }

    /**
     * 格式化list为字符串
     *
     * @param list 类型list
     * @return 字符串 A/B/C..
     */
    private String pListToString(List<PersonBean> list) {
        String str = "";
        if (list.size() == 0)
            return str;
        for (int i = 0; i < list.size(); i++) {
            str = str + list.get(i).getName();
            if (i < list.size() - 1)
                str += " / ";
        }
        return str;
    }


}
