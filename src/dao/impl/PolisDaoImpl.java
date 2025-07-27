package dao.impl;

import util.DatabaseConnection;
import dao.PolisDaoInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Polis;

public class PolisDaoImpl implements PolisDaoInterface {

    @Override
    public void save(Polis polis) throws Exception {
        String sql = "INSERT INTO polis (nasabah_id, jenis, premi) VALUES (?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, polis.getNasabahId());
            ps.setString(2, polis.getJenis());
            ps.setDouble(3, polis.getPremi());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                polis.setId(rs.getInt(1));
            }
        }
    }

    @Override
    public Polis findById(int id) throws Exception {
        String sql = "SELECT p.id, p.nasabah_id, n.nama, p.jenis, p.premi FROM polis p join nasabah n on n.id = p.nasabah_id WHERE p.id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Polis(
                    rs.getInt("id"),
                    rs.getInt("nasabah_id"),
                        rs.getString("nama"),
                    rs.getString("jenis"),
                    rs.getDouble("premi")
                );
            }
            return null;
        }
    }

    @Override
    public List<Polis> findByNasabahId(int nasabahId) throws Exception {
        List<Polis> list = new ArrayList<>();
        String sql = "SELECT p.id, p.nasabah_id, n.nama, p.jenis, p.premi FROM polis p join nasabah n on n.id = p.nasabah_id WHERE p.nasabah_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, nasabahId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Polis p = new Polis(
                    rs.getInt("id"),
                    rs.getInt("nasabah_id"),
                        rs.getString("nama"),
                    rs.getString("jenis"),
                    rs.getDouble("premi")
                );
                list.add(p);
            }
        }
        return list;
    }

    @Override
    public List<Polis> findAll() throws Exception {
        List<Polis> list = new ArrayList<>();
        String sql = "SELECT p.id, p.nasabah_id, n.nama, p.jenis, p.premi FROM polis p join nasabah n on n.id = p.nasabah_id;";
        try (Connection con = DatabaseConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Polis p = new Polis(
                    rs.getInt("id"),
                    rs.getInt("nasabah_id"),
                        rs.getString("nama"),
                    rs.getString("jenis"),
                    rs.getDouble("premi")
                );
                list.add(p);
            }
        }
        return list;
    }
}
