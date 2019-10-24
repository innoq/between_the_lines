package btl.simple.candidate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;

public class ValidationErrors {

  public static class ValidationError {
    private final String message;

    public ValidationError(String message) {
      this.message = message;
    }
  }

  private Map<String, Set<ValidationError>> errors = new HashMap<>();

  public boolean isEmpty() {
    return errors.isEmpty();
  }

  public boolean addError(String key, ValidationError error) {
    if (errors.containsKey(key)) {
      return errors.get(key).add(error);
    } else {
      errors.put(key, newHashSet(error));
      return true;
    }
  }


}
