package com.hui.example.yizhi.bean;

import java.io.Serializable;
import java.util.List;

public class SubjectsBean  implements Serializable {
        /**
         * rating : {"max":10,"average":8.8,"stars":"45","min":0}
         * genres : ["动作","科幻","动画"]
         * title : 蜘蛛侠：平行宇宙
         * casts : [{"alt":"https://movie.douban.com/celebrity/1350106/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1434437756.07.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1434437756.07.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1434437756.07.webp"},"name":"沙梅克·摩尔","id":"1350106"},{"alt":"https://movie.douban.com/celebrity/1316713/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1449582908.84.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1449582908.84.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1449582908.84.webp"},"name":"杰克·约翰逊","id":"1316713"},{"alt":"https://movie.douban.com/celebrity/1312964/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20419.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20419.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20419.webp"},"name":"海莉·斯坦菲尔德","id":"1312964"}]
         * collect_count : 117815
         * original_title : Spider-Man: Into the Spider-Verse
         * subtype : movie
         * directors : [{"alt":"https://movie.douban.com/celebrity/1310107/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1519064730.28.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1519064730.28.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1519064730.28.webp"},"name":"鲍勃·佩尔西凯蒂","id":"1310107"},{"alt":"https://movie.douban.com/celebrity/1324415/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p59042.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p59042.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p59042.webp"},"name":"彼得·拉姆齐","id":"1324415"},{"alt":"https://movie.douban.com/celebrity/1296189/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1543307159.85.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1543307159.85.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1543307159.85.webp"},"name":"罗德尼·罗斯曼","id":"1296189"}]
         * year : 2018
         * images : {"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2542867516.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2542867516.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2542867516.webp"}
         * alt : https://movie.douban.com/subject/26374197/
         * id : 26374197
         */

        private RatingBean rating;
        private String title;
        private int collect_count;
        private String original_title;
        private String subtype;
        private String year;
        private ImagesBean images;
        private String alt;
        private String id;
        private List<String> genres;
        private List<CastsBean> casts;
        private List<DirectorsBean> directors;

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getCollect_count() {
            return collect_count;
        }

        public void setCollect_count(int collect_count) {
            this.collect_count = collect_count;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
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

        public List<String> getGenres() {
            return genres;
        }

        public void setGenres(List<String> genres) {
            this.genres = genres;
        }

        public List<CastsBean> getCasts() {
            return casts;
        }

        public void setCasts(List<CastsBean> casts) {
            this.casts = casts;
        }

        public List<DirectorsBean> getDirectors() {
            return directors;
        }

        public void setDirectors(List<DirectorsBean> directors) {
            this.directors = directors;
        }

        public static class RatingBean {
            /**
             * max : 10
             * average : 8.8
             * stars : 45
             * min : 0
             */

            private int max;
            private double average;
            private String stars;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public double getAverage() {
                return average;
            }

            public void setAverage(double average) {
                this.average = average;
            }

            public String getStars() {
                return stars;
            }

            public void setStars(String stars) {
                this.stars = stars;
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
             * small : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2542867516.webp
             * large : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2542867516.webp
             * medium : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2542867516.webp
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

        public static class CastsBean {
            /**
             * alt : https://movie.douban.com/celebrity/1350106/
             * avatars : {"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1434437756.07.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1434437756.07.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1434437756.07.webp"}
             * name : 沙梅克·摩尔
             * id : 1350106
             */

            private String alt;
            private AvatarsBean avatars;
            private String name;
            private String id;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsBean getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBean avatars) {
                this.avatars = avatars;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public static class AvatarsBean {
                /**
                 * small : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1434437756.07.webp
                 * large : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1434437756.07.webp
                 * medium : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1434437756.07.webp
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
        }

        public static class DirectorsBean {
            /**
             * alt : https://movie.douban.com/celebrity/1310107/
             * avatars : {"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1519064730.28.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1519064730.28.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1519064730.28.webp"}
             * name : 鲍勃·佩尔西凯蒂
             * id : 1310107
             */

            private String alt;
            private AvatarsBeanX avatars;
            private String name;
            private String id;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsBeanX getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBeanX avatars) {
                this.avatars = avatars;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public static class AvatarsBeanX {
                /**
                 * small : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1519064730.28.webp
                 * large : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1519064730.28.webp
                 * medium : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1519064730.28.webp
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
        }


    /**
     * 获取导演字符串
     *
     * @return 导演字符串 A/B/C..
     */
    public String getDirectorsString() {
        return dListToString(getDirectors());
    }

    /**
     * 获取演员字符串
     *
     * @return 演员字符串 A/B/C..
     */
    public String getActorsString() {
        return cListToString(getCasts());
    }




    /**
     * 获取类型字符串
     *
     * @return 类型字符串 A/B/C..
     */
    public String getGenresString() {
        return sListToString(getGenres());
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
     *
     *  导演
     * 格式化list为字符串
     *
     * @param list 类型list
     * @return 字符串 A/B/C..
     */
    private String dListToString(List<DirectorsBean> list) {
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

    /**
     *
     *  演员
     * 格式化list为字符串
     *
     * @param list 类型list
     * @return 字符串 A/B/C..
     */
    private String cListToString(List<CastsBean> list) {
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
