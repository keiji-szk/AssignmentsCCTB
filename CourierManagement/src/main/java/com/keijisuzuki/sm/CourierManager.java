package com.keijisuzuki.sm;

import java.util.*;

public class CourierManager {
    private List<Package> packages;

    public CourierManager() {
        packages = new ArrayList<>();
    }

    public void addPackage(Package pkg) {
        packages.add(pkg);
    }

    public void displayPackages() {
        if (packages.isEmpty()) {
            System.out.println("No packages available.");
        } else {
            System.out.println("Package List:");
            for (int i = 0; i < packages.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, packages.get(i).toString());
            }
        }
    }

    public void sortPackagesByWeight() {
        System.out.println("Sorting packages by weight...");
        for (int i = 0; i < packages.size() - 1; i++) {
            for (int j = 0; j < packages.size() - i - 1; j++) {
                if (packages.get(j).getWeight() > packages.get(j + 1).getWeight()) {
                    Collections.swap(packages, j, j + 1);
                }
            }
        }
        System.out.println("Packages sorted by weight!");
    }

    public Package searchPackageByTrackingID(String trackingID) {
        System.out.println("Searching for package...");
        packages.sort(Comparator.comparing(Package::getTrackingID));

        int low = 0, high = packages.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            Package pkg = packages.get(mid);
            if (pkg.getTrackingID().equals(trackingID)) {
                return pkg;
            } else if (pkg.getTrackingID().compareTo(trackingID) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}
