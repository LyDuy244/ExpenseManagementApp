/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnnd.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "transaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaction.findAll", query = "SELECT t FROM Transaction t"),
    @NamedQuery(name = "Transaction.findById", query = "SELECT t FROM Transaction t WHERE t.id = :id"),
    @NamedQuery(name = "Transaction.findByPurpose", query = "SELECT t FROM Transaction t WHERE t.purpose = :purpose"),
    @NamedQuery(name = "Transaction.findByDescription", query = "SELECT t FROM Transaction t WHERE t.description = :description"),
    @NamedQuery(name = "Transaction.findByAmount", query = "SELECT t FROM Transaction t WHERE t.amount = :amount"),
    @NamedQuery(name = "Transaction.findByCreatedDate", query = "SELECT t FROM Transaction t WHERE t.createdDate = :createdDate"),
    @NamedQuery(name = "Transaction.findByIsActive", query = "SELECT t FROM Transaction t WHERE t.isActive = :isActive")})
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull(message = "{transaction.purpose.notNull}")
    @Size(min = 1, max = 50, message = "{transaction.purpose.lenErr}")
    @Column(name = "purpose")
    private String purpose;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private long amount;
    @Basic(optional = false)
    @NotNull(message = "{transaction.createdDate.notNull}")
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;
    @Basic(optional = false)
    @Column(name = "is_active")
    private boolean isActive;
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TypeTransaction typeId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public Transaction() {
    }

    public Transaction(Integer id) {
        this.id = id;
    }

    public Transaction(Integer id, String purpose, long amount, Date createdDate, boolean isActive) {
        this.id = id;
        this.purpose = purpose;
        this.amount = amount;
        this.createdDate = createdDate;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public TypeTransaction getTypeId() {
        return typeId;
    }

    public void setTypeId(TypeTransaction typeId) {
        this.typeId = typeId;
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
        if (!(object instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lnnd.pojo.Transaction[ id=" + id + " ]";
    }

}
