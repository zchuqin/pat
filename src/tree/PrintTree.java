package tree;

import java.io.File;
import java.util.function.Function;

public class PrintTree {

    private static final char START_CHARACTER = '├';
    private static final char GO_ON_CHARACTER = '─';
    private static final char SPAN_CHARACTER = '│';
    private static final char END_CHARACTER = '└';
    private static final char BLANK_CHARACTER = ' ';
    private static final String LINE_SEPARATOR = System.lineSeparator();


    public static void main(String[] args) {
        File file = new File("E:\\work");
//        System.out.println(ergodic(file));
        System.out.println(printTree(file, (f) -> f.listFiles(File::isDirectory), File::getName));
    }

    private static <T> String printTree(T element, Function<T, T[]> getChildren, Function<T, String> getName) {
        Tree<T> tTree = new Tree<>(element, getChildren, getName);
        StringBuilder content = new StringBuilder();
        StringBuilder pre = new StringBuilder();
        printTree(tTree, pre, content);
        return content.toString();
    }

    private static <T> void printTree(Tree<T> tTree, StringBuilder prefix, StringBuilder content) {
        T[] children = tTree.getChildren();
        if (children != null) {
            for (int i = 0; i < children.length; i++) {
                if (prefix.length() > 0) {
                    switch (prefix.charAt(prefix.length()-1)) {
                        case START_CHARACTER:
                            prefix.setCharAt(prefix.length() - 1, SPAN_CHARACTER);
                            break;
                        case END_CHARACTER:
                            prefix.setCharAt(prefix.length() - 1, BLANK_CHARACTER);
                            break;
                        default:
                    }
                    if (i == 0) {
                        prefix.append(BLANK_CHARACTER).append(BLANK_CHARACTER)
                                .append(children.length > 1 ? START_CHARACTER : END_CHARACTER);
                    } else {
                        prefix.setCharAt(prefix.length() - 1,
                                i == children.length - 1 ? END_CHARACTER : START_CHARACTER);
                    }
                } else {
                    prefix.append(children.length > 1 ? START_CHARACTER : END_CHARACTER);
                }
                Tree<T> tTree1 = new Tree<>(children[i], tTree.getChildrenAction, tTree.getNameAction);
                content.append(prefix).append(GO_ON_CHARACTER).append(tTree1.getName()).append(LINE_SEPARATOR);
                printTree(tTree1, new StringBuilder(prefix), content);
            }
        }
    }

    private static String ergodic(File file) {
        StringBuilder content = new StringBuilder();
        StringBuilder pre = new StringBuilder();
        ergodic(file, pre, content);
        return content.toString();
    }

    private static void ergodic(File file, StringBuilder prefix, StringBuilder content) {
        File[] files = file.listFiles(File::isDirectory);
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (prefix.length() > 0) {
                    switch (prefix.charAt(prefix.length()-1)) {
                        case START_CHARACTER:
                            prefix.setCharAt(prefix.length() - 1, SPAN_CHARACTER);
                            break;
                        case END_CHARACTER:
                            prefix.setCharAt(prefix.length() - 1, BLANK_CHARACTER);
                            break;
                        default:
                    }
                    if (i == 0) {
                        prefix.append(BLANK_CHARACTER).append(BLANK_CHARACTER)
                                .append(files.length > 1 ? START_CHARACTER : END_CHARACTER);
                    } else {
                        prefix.setCharAt(prefix.length() - 1,
                                i == files.length - 1 ? END_CHARACTER : START_CHARACTER);
                    }
                } else {
                    prefix.append(files.length > 1 ? START_CHARACTER : END_CHARACTER);
                }
                content.append(prefix).append(GO_ON_CHARACTER).append(files[i].getName()).append(LINE_SEPARATOR);
                ergodic(files[i], new StringBuilder(prefix), content);
            }
        }

    }


    public static void main1(String[] args) {
        char c = '└';
        char c1 = '├';
        char c2 = '─';
        char c3 = '│';
        char c4 = '速';

        System.out.println((int)c);
        System.out.println((int)c1);
        System.out.println((int)c2);
        System.out.println((int)c3);
        System.out.println((int)c4);


    }

    private static class Tree<T> {
        T element;
        Function<T, T[]> getChildrenAction;
        Function<T, String> getNameAction;

        Tree(T element, Function<T,T[]> getChildrenAction, Function<T,String> getNameAction) {
            this.element = element;
            this.getChildrenAction = getChildrenAction;
            this.getNameAction = getNameAction;
        }

        String getName() {
            return getNameAction.apply(element);
        }

        T[] getChildren() {
            return getChildrenAction.apply(element);
        }
    }
}
