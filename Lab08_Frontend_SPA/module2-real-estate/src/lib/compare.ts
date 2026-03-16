import type { Property } from "@/types/property";

const KEY = "compare-properties";

export function loadCompare(): Property[] {
  const data = localStorage.getItem(KEY);
  return data ? JSON.parse(data) : [];
}

export function saveCompare(properties: Property[]) {
  localStorage.setItem(KEY, JSON.stringify(properties));
}

export function toggleCompare(property: Property): Property[] {

  const current = loadCompare();
  const exists = current.find(p => p.id === property.id);

  let updated: Property[];

  if (exists) {
    updated = current.filter(p => p.id !== property.id);
  } else {

    if (current.length >= 3) {
      alert("Solo puedes comparar hasta 3 propiedades");
      return current;
    }

    updated = [...current, property];
  }

  saveCompare(updated);
  return updated;
}