package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    public void setId(Long id) {
        this.id = id;
    }

    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @OneToOne(mappedBy = "shippingCar")
    private User user;

    public Car(String model, int series, Long id, User user) {
        this.model = model;
        this.series = series;
        this.id = id;
        this.user = user;
    }

    public Car(User user) {
        this.user = user;
    }
}
