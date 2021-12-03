package webtech.deardiary.persistence.Author;

import javax.persistence.*;

@Entity(name = "Author")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Author_ID")
    private long author_ID;

    @Column(name = "first_name", nullable = false)
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "nickname")
    private String nickname;

    public AuthorEntity(String first_name, String last_name, String nickname) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.nickname = nickname;
    }

    protected AuthorEntity() { }

    public long getAuthor_ID() { return author_ID; }

    public String getFirst_name() { return first_name; }

    public void setFirst_name(String first_name) { this.first_name = first_name; }

    public String getLast_name() { return last_name; }

    public void setLast_name(String last_name) { this.last_name = last_name; }

    public String getNickname() { return nickname; }

    public void setNickname(String nickname) { this.nickname = nickname; }
}
