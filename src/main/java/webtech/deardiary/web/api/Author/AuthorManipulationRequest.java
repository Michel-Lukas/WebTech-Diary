package webtech.deardiary.web.api.Author;

public class AuthorManipulationRequest {

    private String first_name;
    private String last_name;
    private String nickname;

    public AuthorManipulationRequest(String first_name, String last_name, String nickname) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.nickname = nickname;
    }

    public String getFirst_name() { return first_name; }

    public void setFirst_name(String first_name) { this.first_name = first_name; }

    public String getLast_name() { return last_name; }

    public void setLast_name(String last_name) { this.last_name = last_name; }

    public String getNickname() { return nickname; }

    public void setNickname(String nickname) { this.nickname = nickname; }
}
