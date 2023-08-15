/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnnd.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "group_member")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupMember.findAll", query = "SELECT g FROM GroupMember g"),
    @NamedQuery(name = "GroupMember.findById", query = "SELECT g FROM GroupMember g WHERE g.id = :id"),
    @NamedQuery(name = "GroupMember.findByContribution", query = "SELECT g FROM GroupMember g WHERE g.contribution = :contribution"),
    @NamedQuery(name = "GroupMember.findByBalance", query = "SELECT g FROM GroupMember g WHERE g.balance = :balance"),
    @NamedQuery(name = "GroupMember.findByIsActive", query = "SELECT g FROM GroupMember g WHERE g.isActive = :isActive")})
public class GroupMember implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contribution")
    private double contribution;
    @Basic(optional = false)
    @NotNull
    @Column(name = "balance")
    private double balance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private boolean isActive;
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GroupExpense groupId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public GroupMember() {
    }

    public GroupMember(Integer id) {
        this.id = id;
    }

    public GroupMember(Integer id, double contribution, double balance, boolean isActive) {
        this.id = id;
        this.contribution = contribution;
        this.balance = balance;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getContribution() {
        return contribution;
    }

    public void setContribution(double contribution) {
        this.contribution = contribution;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public GroupExpense getGroupId() {
        return groupId;
    }

    public void setGroupId(GroupExpense groupId) {
        this.groupId = groupId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupMember)) {
            return false;
        }
        GroupMember other = (GroupMember) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lnnd.pojo.GroupMember[ id=" + id + " ]";
    }
    
}
