package an2myc.repository;

import an2myc.model.Phone;
import an2myc.util.IdProvider;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhoneRepository {

    private static final PhoneRepository INSTANCE = new PhoneRepository();

    private final Map<Long, Phone> storage;
    private final IdProvider idProvider = IdProvider.getInstance();

    private PhoneRepository() {
        this.storage = Stream.of(new Phone(this.idProvider.getNewId(), "IPhone", "13 pro", "12-3UTFBK-NBA62F-F"),
                        new Phone(this.idProvider.getNewId(), "OnePlus", "12", "G3-KHR6M-37D4K1-H"),
                        new Phone(this.idProvider.getNewId(), "Nokia", "3310", "FA-BNGF74-KG83JA-T"),
                        new Phone(this.idProvider.getNewId(), "Samsung", "Galaxy A15", "AA-HBA89J-84LD7D-D"),
                        new Phone(this.idProvider.getNewId(), "Alcatel", "5031G", "DA-BCJ62A-NSAJH5-S"))
                .collect(Collectors.toMap(Phone::getId, Function.identity()));
    }

    public static PhoneRepository getInstance() {
        return INSTANCE;
    }

    public Phone findById(Long id) {
        return this.storage.get(id);
    }

    public List<Phone> findAll() {
        return List.copyOf(this.storage.values());
    }

    public Phone create(String manufacturer, String type, String licensePlate) {
        var id = this.idProvider.getNewId();
        return this.storage.put(id, new Phone(id, manufacturer, type, licensePlate));
    }

    public Phone update(Phone phone) {
        if (this.storage.get(phone.getId()) != null) {
            return this.storage.put(phone.getId(), phone);
        } else {
            throw new RuntimeException("Phone with id: " + phone.getId() + " does not exist.");
        }
    }

    public Phone delete(Long id) {
        return this.storage.remove(id);
    }

}
