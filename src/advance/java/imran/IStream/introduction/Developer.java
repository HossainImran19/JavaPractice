package advance.java.imran.IStream.introduction;

import java.util.HashSet;
import java.util.Set;

public class Developer {
    private String name;
    private Set<String> languages;

    public Developer(String name) {
        this.name = name;
        this.languages = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getLanguages() {
        return languages;
    }

    public void add(String languages) {
        this.languages.add(languages);
    }
}
