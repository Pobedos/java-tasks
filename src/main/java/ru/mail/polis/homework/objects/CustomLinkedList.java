package ru.mail.polis.homework.objects;

/**
 * Реализовать все методы односвязанного списка.
 */
public class CustomLinkedList {

    private Node head;
    private int size;

    /**
     * Реализовать метод:
     * Добавляет элемент в односвязны список.
     *
     * @param value - data for create Node.
     */
    public void add(int value) {
        size++;
        if (head == null) {
            head = new Node(value);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.setNext(new Node(value));
    }

    /**
     * Реализовать метод:
     * Удаляет элемент в указанной позиции, при это связывая его соседние элементы друг с другом.
     * Если был передан невалидный index - надо выкинуть исключение IndexOutOfBoundsException.
     *
     * @param index - position what element need remove.
     */
    public void removeElement(int index) {
        if ((head == null) || (index < 0) || (index >= size)) {
            throw new IndexOutOfBoundsException();
        }
        size--;
        if (index == 0) {
            head = head.next;
            return;
        }
        Node prev = null;
        Node current = head;
        int currentIndex = 0;
        while (index != currentIndex) {
            prev = current;
            current = current.next;
            currentIndex++;
        }
        prev.setNext(current.next);
    }

    /**
     * Реализовать метод:
     * Переварачивает все элементы списка.
     * Пример:
     *  Исходная последовательность списка "1 -> 2 -> 3 -> 4 -> null"
     *  После исполнения метода последовательность должа быть такой "4 -> 3 -> 2 -> 1 -> null"
     */
    public void revertList() {
        if (head == null) {
            return;
        }
        Node previous = null;
        Node current = head;
        Node next = current.next;
        while (next != null) {
            current.next = previous;
            previous = current;
            current = next;
            next = next.next;
        }
        current.next = previous;
        head = current;
    }

    /**
     * Метод выводит всю последовательность хранящуюся в списке начиная с head.
     * Формат вывода:
     *  - значение каждой Node должно разделяться " -> "
     *  - последовательность всегда заканчивается на null
     *  - если в списке нет элементов - верните строку "null"
     *
     * @return - String with description all list
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node current = head;
        while (current != null) {
            str.append(current.value);
            str.append(" -> ");
            current = current.next;
        }
        str.append("null");
        return str.toString();
    }

    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
