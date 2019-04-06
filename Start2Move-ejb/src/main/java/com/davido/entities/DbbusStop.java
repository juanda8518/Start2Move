/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davido.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author davidortega
 */
@Entity
@Table(name = "db_busStop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DbbusStop.findAll", query = "SELECT d FROM DbbusStop d")
    , @NamedQuery(name = "DbbusStop.findByBusStopId", query = "SELECT d FROM DbbusStop d WHERE d.busStopId = :busStopId")
    , @NamedQuery(name = "DbbusStop.findByStop", query = "SELECT d FROM DbbusStop d WHERE d.stop = :stop")
    , @NamedQuery(name = "DbbusStop.findByX", query = "SELECT d FROM DbbusStop d WHERE d.x = :x")
    , @NamedQuery(name = "DbbusStop.findByY", query = "SELECT d FROM DbbusStop d WHERE d.y = :y")})
public class DbbusStop implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "busStopId")
    private Integer busStopId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "stop")
    private String stop;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "X")
    private BigDecimal x;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Y")
    private BigDecimal y;
    @JoinColumns({
        @JoinColumn(name = "postCode", referencedColumnName = "postCodeId")
        , @JoinColumn(name = "postLine", referencedColumnName = "postCodeLine")})
    @ManyToOne(optional = false)
    private DbpostCode dbpostCode;

    public DbbusStop() {
    }

    public DbbusStop(Integer busStopId) {
        this.busStopId = busStopId;
    }

    public DbbusStop(Integer busStopId, String stop, BigDecimal x, BigDecimal y) {
        this.busStopId = busStopId;
        this.stop = stop;
        this.x = x;
        this.y = y;
    }

    public Integer getBusStopId() {
        return busStopId;
    }

    public void setBusStopId(Integer busStopId) {
        this.busStopId = busStopId;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public BigDecimal getX() {
        return x;
    }

    public void setX(BigDecimal x) {
        this.x = x;
    }

    public BigDecimal getY() {
        return y;
    }

    public void setY(BigDecimal y) {
        this.y = y;
    }

    public DbpostCode getDbpostCode() {
        return dbpostCode;
    }

    public void setDbpostCode(DbpostCode dbpostCode) {
        this.dbpostCode = dbpostCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (busStopId != null ? busStopId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DbbusStop)) {
            return false;
        }
        DbbusStop other = (DbbusStop) object;
        if ((this.busStopId == null && other.busStopId != null) || (this.busStopId != null && !this.busStopId.equals(other.busStopId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.davido.DbbusStop[ busStopId=" + busStopId + " ]";
    }
    
}
