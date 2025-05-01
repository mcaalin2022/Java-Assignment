package Stafff;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service

public class StaffService {
    private final Map<Long, Staff> staffs = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<Staff> getAllStaffs() {
        return new ArrayList<>(staffs.values());
    }

    public Staff getStaffById(Long id) {
        return staffs.get(id);
    }

    public Staff createStaff(Staff staff) {
        Long newId = idGenerator.getAndIncrement();
        staff.setId(newId);
        staffs.put(newId, staff);
        return staff;
    }

    public Staff updateStaff(Long id, Staff staff) {
        if (staffs.containsKey(id)) {
            staff.setId(id);
            staffs.put(id, staff);
            return staff;
        }
        return null; // Or throw an exception
    }

    public void deleteStaff(Long id) {
        staffs.remove(id);
    }
}
