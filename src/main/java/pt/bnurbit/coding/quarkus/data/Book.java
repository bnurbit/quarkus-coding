package pt.bnurbit.coding.quarkus.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @NotBlank(message = "Name must not be blank")
    private String name;

    @NotBlank(message = "Author must not be blank")
    private String author;

    @Min(value = 1, message = "Number of pages must be at least 1")
    private Integer pages;
}
