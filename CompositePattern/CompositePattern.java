package CompositePattern;

import java.util.ArrayList; // import the ArrayList class

abstract class Component {
    abstract int get_size();
}

class File extends Component {

    private int size = 0;

    File(int size) {
        this.size = size;
    }

    @Override
    int get_size() {
        return this.size;
    }
}

class Directory extends Component {

    private ArrayList<Component> children = new ArrayList<Component>();

    public void add_child(Component child) {
        this.children.add(child);
    }

    @Override
    int get_size() {
        int total_size = 0;
        for (int i = 0; i < children.size(); i++) {
            Component child = children.get(i);
            total_size += child.get_size();
        }
        return total_size;
    }
}

public class CompositePattern {

    public static void main(String[] args) {

        Component file1 = new File(4);
        Component file2 = new File(2);
        Directory rootDir = new Directory();
        rootDir.add_child(file1);
        rootDir.add_child(file2);
        Directory subDir = new Directory();
        rootDir.add_child(subDir);

        Component file3 = new File(3);
        subDir.add_child(file3);

        System.out.println(rootDir.get_size());
    }

}
