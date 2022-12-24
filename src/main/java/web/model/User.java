package web.model;

public class User {
    private static Long count = 1L;

    private Long id;
    private String name;
    private String profession;
    private String avatarURL;
    private boolean hasBrains = false;
    private int age;

    public User() {
        this.id = count++;
    }

    public User(String name, String profession, String avatarURL, boolean hasBrains, int age) {
        this.id = count++;
        this.name = name;
        this.profession = profession;
        this.hasBrains = hasBrains;
        this.age = age;
        this.avatarURL = avatarURL;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public boolean isHasBrains() {
        return hasBrains;
    }

    public void setHasBrains(boolean hasBrains) {
        this.hasBrains = hasBrains;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        String pattern = "Пользователь - '%s', id - %s\nПрофессия - '%s'\nУмный? - %s\nВозраст - %d\nСтеснительный? - %s}";
        return pattern.formatted(name, id, profession, hasBrains ? "yes" : "not much", age, avatarURL == null || avatarURL.isEmpty() ? "yes" : "вряд ли");
    }
}
