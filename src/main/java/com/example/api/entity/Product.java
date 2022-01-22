package com.example.api.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false, unique=true)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private int price;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex", nullable = false)
    private Sex sex;

    @Column(name = "image", nullable = false)
    private String img;

    @ManyToOne
    @JoinColumn(name = "category_ID")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "color_ID")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "size_ID")
    private Size size;

    public Product(long id, String name, int price, Sex sex, String img, Category category, Color color, Size size) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sex = sex;
        this.img = img;
        this.category = category;
        this.color = color;
        this.size = size;
    }

    public Product() {

    }

    public static Product createProduct(long id, String name, int price, Sex sex, String img, Category category, Color color, Size size) {
        return new Product(id, name, price, sex, img, category, color, size);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", sex=" + sex +
                ", img='" + img + '\'' +
                ", category=" + category +
                ", color=" + color +
                ", size=" + size +
                '}';
    }

    @Entity
    @Table(name = "categories")
    public static class Category {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        @Column(name = "category", nullable = false)
        private String name;


        private Category(long id, String category) {
            this.id = id;
            this.name = category;
        }

        public Category() {

        }

        public static Category createCategory(long id, String category) {
            return new Category(id, category);
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Category{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    @Entity
    @Table(name = "colors")
    public static class Color {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        @Column(name = "color", nullable = false)
        private String color;

        private Color(long id, String color) {
            this.id = id;
            this.color = color;
        }

        public Color() {

        }

        public static Color createColor(long id, String color) {
            return new Color(id, color);
        }


        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Color{" +
                    "id=" + id +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
    @Entity
    @Table(name = "sizes")
    public static class Size {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        @Column(name = "size", nullable = false)
        private String size;


        private Size(long id, String size) {
            this.id = id;
            this.size = size;
        }

        public Size() {

        }

        public static Size createSize(long id, String size) {
            return new Size(id, size);
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return "Size{" +
                    "id=" + id +
                    ", size='" + size + '\'' +
                    '}';
        }
    }

    public enum Sex {
        Male, Female, Unisex
    }
}
