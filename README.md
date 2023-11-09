# Entity-Relationship-Model-to-Natural-Language
- This Java program models an ER (Entity-Relationship) diagram with entities and relationships. It generates natural language sentences based on specified constraints.
- This ER diagram uses (min, max) notation for defining contraints.

## Code Details

The code is organized into three main components: `ER`, `Entity`, and `Relationship`.

- **ER Class:**
  - The `ER` class serves as the main entry point for the program. It defines instances of entities (e.g., EMPLOYEE, DEPARTMENT, PROJECT) and relationships (e.g., WORKS_FOR, MANAGES, WORKS_ON, CONTROLS) and prints the generated natural language sentences.

- **Entity Class:**
  - The `Entity` class represents an entity in the ER diagram. It has a simple structure with a name attribute. Users can create instances of entities by providing a name.

- **Relationship Class:**
  - The `Relationship` class models a relationship between two entities. It includes details such as the name of the relationship, the left and right entities involved, and an array of notations representing (min, max) constraints.

- **How to Customize Entities and Relationships:**
  - Users can customize the entities and relationships by creating new instances of the `Entity` and `Relationship` classes in the `main` method of the `ER` class. For example:
    ```java
    Entity CUSTOM_ENTITY = new Entity("CUSTOM_ENTITY");
    Entity ANOTHER_ENTITY = new Entity("ANOTHER_ENTITY");

    Relationship CUSTOM_RELATIONSHIP = new Relationship("CUSTOM_RELATIONSHIP", CUSTOM_ENTITY, ANOTHER_ENTITY, new int[]{0, 1, 1, 3});
    CUSTOM_RELATIONSHIP.printResult();
    ```
  - Users can modify the `name` attribute of entities and relationships to suit their specific use case.

