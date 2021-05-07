package containers;

public abstract class Test<C> {
    private String name;

    public Test(String name) {
        this.name = name;
    }

    /**
     * возвращает количество повторений теста
     * @param container тестируемый контейнер
     * @param tp параметры теста: size(количество элементов в
     *           контейнере, loops(количество итераций)
     */
    abstract int test(C container, TestParam tp);
}
