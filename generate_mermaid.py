import json
import os

# Simulate Copilot-like response for generating Mermaid diagram
def get_copilot_response(prompt):
    print(f"Processing prompt: {prompt}")
    # Simulated response with Mermaid diagram code
    response = f"""
```mermaid
graph TD
A[Start] --> B[Build]
B --> C[Test]
C --> D[Deploy]
D --> E[Finish]
    prompt = config.get("prompt")
    output_file = config.get("output_file", "mermaid.md")  # Default output file: mermaid.md
    
    if not prompt:
        print("Error: No prompt found in config.json")
        return
    
    # Get the response (simulated here)
    mermaid_code = get_copilot_response(prompt)
    
    # Save the Mermaid diagram code to the output file
    with open(output_file, 'w') as file:
        file.write(mermaid_code)
    
    print(f"Mermaid diagram generated and saved to {output_file}")

except FileNotFoundError:
    print(f"Error: Configuration file {config_file} not found!")
except json.JSONDecodeError:
    print("Error: Invalid JSON format in config.json")
except Exception as e:
    print(f"An error occurred: {e}")

---

### **How It Works**
1. **Input Configuration:**
   - The script reads a `config.json` file, which contains the following fields:
     - `prompt`: The description of the diagram you want (e.g., "Create a CI/CD pipeline diagram").
     - `output_file`: The name of the file where the Mermaid.js code will be saved (default: `mermaid.md`).

2. **Simulated Copilot Response:**
   - The `get_copilot_response` function simulates generating a Mermaid.js diagram from the provided prompt.

3. **Output File:**
   - The script saves the Mermaid.js code into the specified `output_file`.

---

### **Example Configuration File (`config.json`)**
Save the following content in a `config.json` file:

```json
{
  "prompt": "Create a flowchart for a CI/CD pipeline with stages: Build, Test, Deploy",
  "output_file": "mermaid.md"
}
