package com.codecool.adhoc.ticketportal.model;

import com.codecool.adhoc.ticketportal.model.enums.UserType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(
                name="User.findAllUsers",
                query="SELECT u FROM User u " +
                        "ORDER BY u.id"),
        @NamedQuery(
                name="User.findUserById",
                query="SELECT u FROM User u " +
                        "WHERE u.id = :userId"
        )
})
public class User {
    @Override
    public String toString() {
        return "\nUser" +
                "\nid=" + id +
                "\nuserName='" + userName +
                "\nemail='" + email +
                "\nfullName='" + fullName +
                "\nuserType=" + userType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Cart cart;

    @OneToMany(mappedBy = "users")
    private Set<Order> orders = new HashSet<>();

    @Column(name = "user_name")
    private String userName;

    private String email;

    @Column(name = "full_name")
    private String fullName;

    private String password;

    @Column(name = "card_number")
    private String cardNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private UserType userType;

    public User() {
    }

    public User(String userName, String email, String fullName, UserType userType, Cart cart, Set<Order> orders) {
        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
        this.userType = userType;
        this.cart = cart;
        this.orders = orders;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
