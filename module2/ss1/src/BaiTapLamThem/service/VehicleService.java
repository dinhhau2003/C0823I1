package BaiTapLamThem.service;

import BaiTapLamThem.repository.IVehicleRepository;
import BaiTapLamThem.repository.VehicleRepository;

import java.util.Scanner;

public class VehicleService implements IVehicleService{
    Scanner scanner = new Scanner(System.in);
    private static IVehicleRepository vehicleRepository = new VehicleRepository();
    private static final String BIENSOXE_TRUCK_VALID = "^(43C)-\\d{3}.\\d{2}$";
    private static final String BIENSOXE_CAR_VALID = "^(43)[AB]-\\d{3}.\\d{2}$";
    private static final String BIENSOXE_MOTORBIKE_VALID = "^(43)-[A-Z][A-Z0-9]-[0-9][0-9][0-9].[0-9][0-9]";
    private static final String NAME_VALID = "^([A-Z][a-z]{1,})((\\s[A-Z][a-z]{1,}){1,})$";
    @Override
    public void addVehicle() {

    }

    @Override
    public void displayVehicle() {

    }

    @Override
    public void removeVehicle(String bienKiemSoatdel) {

    }
}
