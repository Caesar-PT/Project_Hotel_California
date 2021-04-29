package com.example.project_hotel_california.request;



public class UserPrinciple  {
//    private static final long serialVersionUID = 1L;
//
//    private Long id;
//
//    private String fullName;
//
//    private String username;
//
//    private String email;
//    private String phoneNumber;
//    private String address;
//
//
//
//
//    @JsonIgnore
//    private String password;
//
//    private Collection<? extends GrantedAuthority> authorities;
//
//    public UserPrinciple(Long id, String fullName, String username, String email,
//                         String phoneNumber, String address, String password,
//                         Collection<? extends GrantedAuthority> authorities) {
//        this.id = id;
//        this.fullName = fullName;
//        this.username = username;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//        this.address = address;
//        this.password = password;
//        this.authorities = authorities;
//    }
//
//    public static UserPrinciple build(AppUser user) {
//        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
//                new SimpleGrantedAuthority(role.getName())
//        ).collect(Collectors.toList());
//
//        return new UserPrinciple(
//                user.getId(),
//                user.getFullName(),
//                user.getUsername(),
//                user.getEmail(),
//                user.getPhoneNumber(),
//                user.getAddress(),
//                user.getPassword(),
//                authorities
//        );
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return fullName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    public static long getSerialVersionUID() {
//        return serialVersionUID;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getFullName() {
//        return fullName;
//    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
//        this.authorities = authorities;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        UserPrinciple user = (UserPrinciple) o;
//        return Objects.equals(id, user.id);
//    }
}
