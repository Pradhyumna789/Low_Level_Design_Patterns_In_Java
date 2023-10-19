import java.util.HashMap;
import java.util.Map;

// Base Singleton class with a registry
public class SingletonRegistry {
    private static Map<String, SingletonRegistry> registry = new HashMap<>();
    protected SingletonRegistry() { } // Constructor is protected

    // Register a named Singleton instance
    public static void registerInstance(String name, SingletonRegistry instance) {
        registry.put(name, instance);
    }

    // Get a named Singleton instance
    public static SingletonRegistry getInstance(String name) {
        return registry.get(name);
    }
}

// Subclass of SingletonRegistry
public class SubclassSingleton extends SingletonRegistry {
    private String data;

    public SubclassSingleton(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}

// Usage example
public class Main {
    public static void main(String[] args) {
        SubclassSingleton instance1 = new SubclassSingleton("Instance 1 Data");
        SubclassSingleton instance2 = new SubclassSingleton("Instance 2 Data");

        // Register instances with unique names
        SingletonRegistry.registerInstance("Instance1", instance1);
        SingletonRegistry.registerInstance("Instance2", instance2);

        // Retrieve instances by name
        SubclassSingleton retrievedInstance1 = (SubclassSingleton) SingletonRegistry.getInstance("Instance1");
        SubclassSingleton retrievedInstance2 = (SubclassSingleton) SingletonRegistry.getInstance("Instance2");

        // Check if the retrieved instances match the original instances
        System.out.println("Instance 1 Data: " + retrievedInstance1.getData()); // Output: Instance 1 Data
        System.out.println("Instance 2 Data: " + retrievedInstance2.getData()); // Output: Instance 2 Data
    }
}
