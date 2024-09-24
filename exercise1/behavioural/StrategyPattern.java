interface SortingStrategy {
    void sort(int[] numbers);
}

class BubbleSort implements SortingStrategy {
    @Override
    public void sort(int[] numbers) {
        System.out.println("Sorting using Bubble Sort");
        // Bubble sort implementation
    }
}

class QuickSort implements SortingStrategy {
    @Override
    public void sort(int[] numbers) {
        System.out.println("Sorting using Quick Sort");
        // Quick sort implementation
    }
}

class Context {
    private SortingStrategy strategy;

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void sortArray(int[] numbers) {
        strategy.sort(numbers);
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        Context context = new Context();
        
        int[] numbers = {3, 2, 1};
        context.setStrategy(new BubbleSort());
        context.sortArray(numbers);

        context.setStrategy(new QuickSort());
        context.sortArray(numbers);
    }
}
