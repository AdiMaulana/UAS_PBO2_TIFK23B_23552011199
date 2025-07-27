package dao.impl;

import dao.KlaimDaoInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Klaim;
import util.DatabaseConnection;

public class KlaimDaoImpl implements KlaimDaoInterface {

    @Override
    public void save(Klaim klaim) throws Exception {
        String sql = "INSERT INTO klaim (polis_id, tanggal, status) VALUES (?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, klaim.getPolisId());
            ps.setDate(2, klaim.getTanggal());
            ps.setString(3, klaim.getStatus());
            ps.executeUpdate();
        }
    }

    @Override
    public List<Klaim> getSemuaKlaim() throws Exception {
        List<Klaim> list = new ArrayList<>();
        String sql = "SELECT k.id, k.polis_id, n.nama, n.umur, k.tanggal, k.status FROM klaim k JOIN polis p on p.id = k.polis_id JOIN nasabah n on n.id = p.nasabah_id;";
        try (Connection con = DatabaseConnection.getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Klaim klaim = new Klaim();
                klaim.setId(rs.getInt("id"));
                klaim.setPolisId(rs.getInt("polis_id"));
                klaim.setNamaPeserta(rs.getString("nama"));
                klaim.setUmur(rs.getInt("umur"));
                klaim.setTanggal(rs.getDate("tanggal"));
                klaim.setStatus(rs.getString("status"));
                list.add(klaim);
            }
        }
        return list;
    }

    @Override
    public List<Klaim> findByPolisId(int polisId) throws Exception {
        List<Klaim> list = new ArrayList<>();
        String sql = "SELECT * FROM klaim WHERE polis_id = ?";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, polisId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Klaim k = new Klaim();
                k.setId(rs.getInt("id"));
                k.setPolisId(rs.getInt("polis_id"));
                k.setTanggal(rs.getDate("tanggal"));
                k.setStatus(rs.getString("status"));

                list.add(k);
            }
        }
        return list;
    }
}
