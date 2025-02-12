package com.traini8.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "training_centers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Auto-generated ID

    @NotBlank
    @Size(max = 40)
    private String centerName;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center Code must be exactly 12 alphanumeric characters")
    private String centerCode;

    @Embedded
    private Address address;

    @Min(1)
    private int studentCapacity;

    @ElementCollection
    private List<String> coursesOffered;

    private Instant createdOn; // Auto-generated timestamp

    @Email(message = "Invalid email format")
    private String contactEmail;

    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid phone number")
    private String contactPhone;

    @PrePersist
    protected void onCreate() {
        this.createdOn = Instant.now(); // Set timestamp when object is created
    }
}
