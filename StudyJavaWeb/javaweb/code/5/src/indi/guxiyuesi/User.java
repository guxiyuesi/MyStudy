package indi.guxiyuesi;

public class User {
    private String name;
    private int Id;
    private int score;

    public User(String name, int id, int score) {
        this.name = name;
        Id = id;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", Id=" + Id +
                ", score=" + score +
                '}';
    }
}
