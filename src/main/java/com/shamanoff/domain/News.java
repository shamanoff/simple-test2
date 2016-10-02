package com.shamanoff.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/*@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")*/
@Entity(name = "news")

@XmlRootElement(name = "news")
@XmlType(propOrder = {"id","title","link","date"})

public class News {
    public News(String s) {
    }

    public News() {
        this.id = id;
        this.title = title;
        this.link = link;
        this.date = date;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }
    @XmlElement
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    @XmlElement
    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }
    @XmlElement
    public void setLink(String link) {
        this.link = link;
    }

    public String getDate() {
        return date;
    }
    @XmlElement
    public void setDate(String date) {
        this.date = date;
    }

    @Id
    private Long id;

    private String title;

    private String link;

    private String date;


}
